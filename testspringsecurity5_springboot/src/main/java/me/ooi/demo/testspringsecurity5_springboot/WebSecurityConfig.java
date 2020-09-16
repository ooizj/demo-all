package me.ooi.demo.testspringsecurity5_springboot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig {

	private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

		String[][] usersGroupsAndRoles = { { "system", "password", "ROLE_ACTIVITI_USER" },
				{ "salaboy", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
				{ "ryandawsonuk", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
				{ "erdemedeiros", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam" },
				{ "other", "password", "ROLE_ACTIVITI_USER", "GROUP_otherTeam" },
				{ "admin", "password", "ROLE_ACTIVITI_ADMIN" },

				{ "u1", "password", "ROLE_ACTIVITI_USER", "g1", "group1" },
				{ "u2", "password", "ROLE_ACTIVITI_USER", "g2", "group2" },
				{ "u3", "password", "ROLE_ACTIVITI_USER", "g3", "group3" }, };

		for (String[] user : usersGroupsAndRoles) {
			List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length));
			logger.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings
					+ "]");
			inMemoryUserDetailsManager.createUser(new User(user[0], passwordEncoder().encode(user[1]),
					authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
		}

		return inMemoryUserDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}