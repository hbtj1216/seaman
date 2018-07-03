package com.tao.seaman.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Redis工具类
 *
 * @author taojie6 2018/7/3 18:55
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018年07月03日
 * @modify by reason:{方法名}:{原因}
 */
public class RedisUtil {

    protected static ReentrantLock lockPool = new ReentrantLock();
    protected static ReentrantLock lockJedis = new ReentrantLock();

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * Redis服务ip
     */
    private static String IP = PropertiesFileUtil.getInstance("/properties/redis.properties").getString("seaman.redis.ip");

    /**
     * Redis服务端口
     */
    private static int PORT = PropertiesFileUtil.getInstance("/properties/redis.properties").getInteger("seaman.redis.port");

    /**
     * 访问密码
     */
    private static String PASSWORD = AESUtil.aesDecode(PropertiesFileUtil.getInstance("redis").get("master.redis.password"));

    /**
     * 可用连接实例的最大数目，默认值为8；
     * 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
     */
    private static int MAX_ACTIVE = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_active");

    /**
     * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
     */
    private static int MAX_IDLE = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_idle");

    /**
     * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
     */
    private static int MAX_WAIT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_wait");

    /**
     * 超时时间
     */
    private static int TIME_OUT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.timeout");

    /**
     * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
     */
    private static boolean TEST_ON_BORROW = false;

    /**
     * Jedis客户端
     */
    private static JedisPool jedisPool = null;

    /**
     * Redis过期时间, 1小时, 单位(s)
     */
    public static final int EXPIRE_HOUR = 60 * 60;
    /**
     * Redis过期时间, 1天, 单位(s)
     */
    public static final int EXPIRE_DAY = 24 * 60 * 60;
    /**
     * Redis过期时间, 1个月(按30天计算), 单位(s)
     */
    public static final int EXPIRE_MONTH = 30 * 24 * 60 * 60;



    /**
     * 同步获取Jedis实例
     *
     * @return Jedis
     */
    public static synchronized Jedis getJedis() {
        poolInit();
        Jedis jedis = null;
        try {
            if (null != jedisPool) {
                jedis = jedisPool.getResource();
                try {
                    jedis.auth(PASSWORD);
                } catch (Exception e) {
                    LOGGER.error("Redis authentication failed : " + e);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Get redis error : " + e);
        }
        return jedis;
    }

    /**
     * 设置String
     * @param key
     * @param value
     */
    public static synchronized void set(String key, String value) {

    }


/**
 * 初始化Redis连接池
 */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, IP, PORT, TIME_OUT);
        } catch (Exception e) {
            LOGGER.error("Create JedisPool error : " + e);
        }
    }

    /**
     * 在多线程环境下同步初始化
     */
    private static synchronized void poolInit() {
        if (null == jedisPool) {
            initialPool();
        }
    }

/*    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }*/

}










