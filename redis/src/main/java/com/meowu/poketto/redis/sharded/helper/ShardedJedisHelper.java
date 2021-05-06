package com.meowu.poketto.redis.sharded.helper;

import com.meowu.poketto.commons.utils.AssertUtils;
import com.meowu.poketto.commons.utils.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.ShardedJedis;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class ShardedJedisHelper{

    public static void save(ShardedJedis jedis, String key, Object value){
        assertClient(jedis);
        assertKey(key);

        jedis.set(key, getValue(value));
    }

    public static void saveAndExpire(ShardedJedis jedis, String key, Object value, long seconds){
        saveAndExpire(jedis, key, value, TimeUnit.SECONDS, seconds);
    }

    public static void saveAndExpire(ShardedJedis jedis, String key, Object value, TimeUnit timeUnit, long expire){
        assertClient(jedis);
        assertKey(key);

        //保存记录
        jedis.set(key, getValue(value));

        //设置有效时间
        if(timeUnit != null && TimeUnit.MILLISECONDS.equals(timeUnit)){
            jedis.pexpire(key, expire);
        }else{
            jedis.expire(key, timeUnit.toSeconds(expire));
        }
    }

    public static void expire(ShardedJedis jedis, String key, long seconds){
        expire(jedis, key, TimeUnit.SECONDS, seconds);
    }

    public static void expire(ShardedJedis jedis, String key, TimeUnit timeUnit, long expire){
        assertClient(jedis);
        assertKey(key);

        //设置有效时间
        if(timeUnit != null && TimeUnit.MILLISECONDS.equals(timeUnit)){
            jedis.pexpire(key, expire);
        }else{
            jedis.expire(key, timeUnit.toSeconds(expire));
        }
    }

    public static <T> T get(ShardedJedis jedis, String key, Class<T> clazz){
        assertClient(jedis);
        assertKey(key);

        return getValue(jedis.get(key), clazz);
    }

    public static <T> T get(ShardedJedis jeids, String key, Type type){
        assertClient(jeids);
        assertKey(key);

        return getValue(jeids.get(key), type);
    }

    public static void delete(ShardedJedis jedis, String key){
        assertClient(jedis);
        assertKey(key);

        jedis.del(key);
    }

    public static boolean exist(ShardedJedis jedis, String key){
        assertClient(jedis);
        assertKey(key);

        return jedis.exists(key);
    }

    public static long ttl(ShardedJedis jedis, String key){
        return ttl(jedis, key, TimeUnit.SECONDS);
    }

    public static long ttl(ShardedJedis jedis, String key, TimeUnit timeUnit){
        assertClient(jedis);
        assertKey(key);

        if(timeUnit != null && TimeUnit.MILLISECONDS.equals(timeUnit)){
            return jedis.pttl(key);
        }else{
            return jedis.ttl(key);
        }
    }

    public static long incr(ShardedJedis jedis, String key){
        return incr(jedis, key, 1L);
    }

    public static long incr(ShardedJedis jedis, String key, long amount){
        assertClient(jedis);
        assertKey(key);

        return jedis.incrBy(key, amount);
    }

    public static long decr(ShardedJedis jedis, String key){
        return decr(jedis, key, 1L);
    }

    public static long decr(ShardedJedis jedis, String key, long amount){
        assertClient(jedis);
        assertKey(key);

        return jedis.decrBy(key, amount);
    }

    public static double incrByDouble(ShardedJedis jedis, String key){
        return incrByDouble(jedis, key, 1D);
    }

    public static double incrByDouble(ShardedJedis jedis, String key, double amount){
        assertClient(jedis);
        assertKey(key);

        return jedis.incrByFloat(key, amount);
    }

    public static double decrByDouble(ShardedJedis jedis, String key){
        return incrByDouble(jedis, key, -1D);
    }

    public static double decrByDouble(ShardedJedis jedis, String key, double amount){
        return incrByDouble(jedis, key, -amount);
    }

    private static void assertClient(ShardedJedis jedis){
        AssertUtils.notNull(jedis, "jedis client must not be null");
    }

    private static void assertKey(String key){
        AssertUtils.isNotBlank(key, "jedis key must not be null");
    }

    private static boolean notNullValue(String value){
        return StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value);
    }

    private static String getValue(Object value){
        AssertUtils.notNull(value, "jedis value must not be null");

        return GsonUtils.serialize(value);
    }

    private static <T> T getValue(String value, Class<T> clazz){
        if(notNullValue(value)){
            return GsonUtils.deserialize(value, clazz);
        }

        return null;
    }

    private static <T> T getValue(String value, Type type){
        if(notNullValue(value)){
            return GsonUtils.deserialize(value, type);
        }

        return null;
    }
}
