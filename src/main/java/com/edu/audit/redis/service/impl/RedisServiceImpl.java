package com.edu.audit.redis.service.impl;

import com.edu.audit.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisServiceImpl
 * @Description: Redis 服务层
 * @Author: Vince
 * @Date: 2020/2/16 14:13
 * @Version: v1.0
 */
@Service
@PropertySource("classpath:config/redis.properties")
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void set(String key, String value) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value);

    }
    @Override
    public String get(String key) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(key);
    }
    @Override
    public boolean expire(String key, long expire) {
        Boolean expire2 = stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        return expire2;
    }
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
