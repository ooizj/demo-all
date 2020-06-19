package me.ooi.demo.testspringboot213.testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import me.ooi.demo.testspringboot213.mapper.UserMapper;
import me.ooi.demo.testspringboot213.service.UserService;

/**
 * @author jun.zhao
 * @since 1.0
 */
@RequestMapping("/test")
@Controller
@Slf4j
public class TestController {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private UserService userService;

	@GetMapping("/testget")
	@ResponseBody
	public String testget() {
		log.info("testget");
		
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				synchronized (this) {
					userService.updateUserAge(70L);
				}
			}) .start();
		}
		
		return "this is a page.";
	}
	
	
	@GetMapping("/testget2")
	@ResponseBody
	public String testget2() {
		log.info("testget2");
		
		redisTemplate.opsForValue().set("k1", "kkk");
		
		System.out.println(redisTemplate.opsForValue().get("k1"));
		
		return "this is a page2.";
	}
	
}