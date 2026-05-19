package org.gfg.JBDL11_Redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class Config {

    @Bean
    public RedisTemplate<String,String> redisTemplate(){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        lettuceConnectionFactory.setHostName("redis-17216.crce179.ap-south-1-1.ec2.cloud.redislabs.com");
        lettuceConnectionFactory.setPort(17216);
        lettuceConnectionFactory.setPassword("f4oVgHfRWUX9wEJoxIL94QFNLSY7nYX2");
        lettuceConnectionFactory.start();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
