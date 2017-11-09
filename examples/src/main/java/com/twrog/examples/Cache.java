package com.twrog.examples;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;

public class Cache {
    public static com.google.common.cache.Cache<String, String> cacheMap = CacheBuilder.newBuilder().softValues()
	    .expireAfterWrite(5000, TimeUnit.MILLISECONDS).build(); // remove the "expireAfterWrite" method for
								    // production

    public static void main(String... strings) throws InterruptedException {
	Cache.cacheMap.put("hello", "world");
	System.out.println(Cache.cacheMap.getIfPresent("hello"));
	Thread.sleep(6000);
	System.out.println(Cache.cacheMap.getIfPresent("hello"));
	System.out.println("Cache program complete.");
    }
}
