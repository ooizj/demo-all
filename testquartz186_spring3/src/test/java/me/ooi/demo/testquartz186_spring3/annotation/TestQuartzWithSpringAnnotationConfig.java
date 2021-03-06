package me.ooi.demo.testquartz186_spring3.annotation;

import static me.ooi.demo.testquartz186_spring3.TestUtils.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jun.zhao
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context-annotation.xml")
public class TestQuartzWithSpringAnnotationConfig {
	
	@Test
	public void t1() {
		
		//Keep test thread alive 10s
		sleep(1000*10);
	}
	
}
