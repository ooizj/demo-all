package me.ooi.demo.testspringboot213.testcontroller;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import me.ooi.demo.testspringboot213.service.UserService;

/**
 * @author jun.zhao
 * @since 1.0
 */
@RequestMapping("/testlock")
@Controller
@Slf4j
public class TestLockController {
	
	@Autowired
	private RedissonClient redissonClient;
	
	@GetMapping("/testLock")
	@ResponseBody
	public String testLock() {
		log.info("testLock");
		
//		RLock lock = redissonClient.getLock("lock1");
//		
//		// 加锁以后10秒钟自动解锁
//		// 无需调用unlock方法手动解锁
//		lock.lock(10, TimeUnit.SECONDS);
//
//		try {
//			// 尝试加锁，最多等待2秒
//			boolean res = lock.tryLock(2, TimeUnit.SECONDS);
//			if (res) {
//			   try {
//			     
//				   System.out.println("1");
//				   Thread.sleep(1000);
//				   
//			   } finally {
//			       lock.unlock();
//			   }
//			}
//		} catch (InterruptedException e) {
//			log.error(e.getMessage(), e);
//		}
		
		
		return "this is a page.";
	}
	
}
