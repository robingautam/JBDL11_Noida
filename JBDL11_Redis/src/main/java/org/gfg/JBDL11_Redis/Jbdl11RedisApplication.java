package org.gfg.JBDL11_Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Jbdl11RedisApplication implements CommandLineRunner {

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Jbdl11RedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		redisTemplate.opsForValue().set("Two", "2");
		System.out.println(redisTemplate.opsForValue().get("Two"));
		//redisTemplate.opsForValue().set("2", "Two", 60, TimeUnit.SECONDS);
	//	System.out.println(redisTemplate.opsForValue().get("2"));
	}
}
