package com.tao.seaman.common.util;

import java.io.IOException;
import java.util.*;

/**
 * @author taojie6 2018/7/3 19:23
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018年07月03日
 * @modify by reason:{方法名}:{原因}
 */
public class PropertiesFileUtil {

    /**
     * 缓存多个资源文件
     */
    private static Map<String, PropertiesFileUtil> configMap = new HashMap<>();

    /**
     * 打开资源文件的时间, 用来判断超时
     */
    private Date loadTime = null;

    /**
     * 资源文件
     */
    private Properties properties = null;

    /**
     * 默认资源文件的名称
     */
    private static final String NAME = "config";

    /**
     * 默认缓存时间, 60s
     */
    private static final Integer TIME_OUT = 60 * 1000;

    private static final String TRUE = "true";

    private static final String FALSE = "false";


    private PropertiesFileUtil(String name) {
        this.loadTime = new Date();
        this.properties = new Properties();
        try {
            this.properties.load(this.getClass().getResourceAsStream(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取资源文件
     *
     * @param name 资源文件名
     * @return 加载资源的PropertiesFileUtil工具类对象
     */
    public static synchronized PropertiesFileUtil getInstance(String name) {
        PropertiesFileUtil config = configMap.get(name);
        if (null == config) {
            config = new PropertiesFileUtil(name);
            configMap.put(name, config);
        }
        // 判断打开的资源文件是否超过60s, 如果超时, 重新加载
        if ((System.currentTimeMillis() - config.getLoadTime().getTime()) > TIME_OUT) {
            config = new PropertiesFileUtil(name);
            configMap.put(name, config);
        }
        return config;
    }

    /**
     * 根据属性名key获取字符串型属性值value
     *
     * @param key 属性名
     * @return 属性值
     */
    public String getString(String key) {
        try {
            return properties.getProperty(key).trim();
        } catch (MissingResourceException e) {
            return "";
        }
    }

    /**
     * 根据属性名key获取Integer型属性值value
     *
     * @param key 属性名
     * @return 属性值
     */
    public Integer getInteger(String key) {
        try {
            String value = properties.getProperty(key).trim();
            return Integer.valueOf(value);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    /**
     * 根据属性名key获取Boolean型属性值value
     * @param key
     * @return
     */
    public Boolean getBoolean(String key) {
        try {
            String value = properties.getProperty(key).trim();
            if (StringUtil.TRUE.equalsIgnoreCase(value.trim())) {
                return true;
            }
            return false;
        } catch (MissingResourceException e) {
            return false;
        }
    }

    /**
     * 获取加载时间
     *
     * @return 资源加载时间
     */
    public Date getLoadTime() {
        return loadTime;
    }
}
