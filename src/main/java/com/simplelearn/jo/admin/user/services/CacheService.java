package com.simplelearn.jo.admin.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@Autowired
	private CacheManager cacheManager;

	public void clearAll() {
		cacheManager.getCacheNames().stream().forEach(c -> cacheManager.getCache(c).clear());
	}
}