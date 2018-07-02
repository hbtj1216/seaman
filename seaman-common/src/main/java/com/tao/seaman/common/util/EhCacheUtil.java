package com.tao.seaman.common.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * EhCache工具类
 *
 * @creater tao
 * @time 2018/6/18
 */
public class EhCacheUtil {

    /**
     * 新增缓存
     *
     * @param cacheName 缓存名(相当于命名空间)
     * @param key       键
     * @param value     值
     */
    public static void put(String cacheName, String key, String value) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            Element element = new Element(key, value);
            cache.put(element);
        }
    }

    /**
     * 获取缓存记录
     *
     * @param cacheName 缓存名(相当于命名空间)
     * @param key       键
     * @return
     */
    public static Object get(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (null == cache) {
            return null;
        }
        Element element = cache.get(key);
        if (null == element) {
            return null;
        }
        return element.getObjectValue();
    }

    /**
     * 删除缓存记录
     *
     * @param cacheName 缓存名(相当于命名空间)
     * @param key       键
     * @return
     */
    public static boolean remove(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (null == cache) {
            return false;
        }
        return cache.remove(key);
    }

    /**
     * 删除全部缓存记录
     *
     * @param cacheName 缓存名(相当于命名空间)
     * @param key       键
     */
    public static void removeAll(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            cache.remove(key);
        }
    }

    /**
     * 获取缓存对象
     *
     * @param cacheName 缓存名(相当于命名空间)
     * @return 缓存对象
     */
    private static Cache getCache(String cacheName) {
        CacheManager cacheManager = CacheManager.getInstance();
        if (null == cacheManager) {
            return null;
        }
        Cache cache = cacheManager.getCache(cacheName);
        if (null == cache) {
            return null;
        }
        return cache;
    }
}
