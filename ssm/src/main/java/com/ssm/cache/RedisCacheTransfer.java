package com.ssm.cache;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class RedisCacheTransfer {

	private JedisConnectionFactory jedisConnectionFactory;
	
	public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
	}

}
