package com.meowu.poketto.redis.sharded.helper;

import com.meowu.poketto.commons.utils.AssertUtils;
import com.meowu.poketto.commons.utils.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.ShardedJedis;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class ShardedJedisHelper{

    public static void save(ShardedJedis client, String key, Object value){
        assertClient(client);
        assertKey(key);

        client.set(key, getValue(value));
    }

    public static void saveAndExpire(ShardedJedis client, String key, Object value, long seconds){
        saveAndExpire(client, key, value, TimeUnit.SECONDS, seconds);
    }

    public static void saveAndExpire(ShardedJedis client, String key, Object value, TimeUnit timeUnit, long expire){
        assertClient(client);
        assertKey(key);

        //保存记录
        client.set(key, getValue(value));

        //设置有效时间
        if(timeUnit != null && TimeUnit.MILLISECONDS.equals(timeUnit)){
            client.pexpire(key, expire);
        }else{
            client.expire(key, timeUnit.toSeconds(expire));
        }
    }

    public static void expire(ShardedJedis client, String key, long seconds){
        expire(client, key, TimeUnit.SECONDS, seconds);
    }

    public static void expire(ShardedJedis client, String key, TimeUnit timeUnit, long expire){
        assertClient(client);
        assertKey(key);

        //设置有效时间
        if(timeUnit != null && TimeUnit.MILLISECONDS.equals(timeUnit)){
            client.pexpire(key, expire);
        }else{
            client.expire(key, timeUnit.toSeconds(expire));
        }
    }

    public static <T> T get(ShardedJedis client, String key, Class<T> clazz){
        assertClient(client);
        assertKey(key);

        return getValue(client.get(key), clazz);
    }

    public static <T> T get(ShardedJedis jeids, String key, Type type){
        assertClient(jeids);
        assertKey(key);

        return getValue(jeids.get(key), type);
    }

    public static void delete(ShardedJedis client, String key){
        assertClient(client);
        assertKey(key);

        client.del(key);
    }

    public static boolean exist(ShardedJedis client, String key){
        assertClient(client);
        assertKey(key);

        return client.exists(key);
    }

    public static long ttl(ShardedJedis client, String key){
        return ttl(client, key, TimeUnit.SECONDS);
    }

    public static long ttl(ShardedJedis client, String key, TimeUnit timeUnit){
        assertClient(client);
        assertKey(key);

        if(timeUnit != null && TimeUnit.MILLISECONDS.equals(timeUnit)){
            return client.pttl(key);
        }else{
            return client.ttl(key);
        }
    }

    public static long incr(ShardedJedis client, String key){
        return incr(client, key, 1L);
    }

    public static long incr(ShardedJedis client, String key, long amount){
        assertClient(client);
        assertKey(key);

        return client.incrBy(key, amount);
    }

    public static long decr(ShardedJedis client, String key){
        return decr(client, key, 1L);
    }

    public static long decr(ShardedJedis client, String key, long amount){
        assertClient(client);
        assertKey(key);

        return client.decrBy(key, amount);
    }

    public static double incrByDouble(ShardedJedis client, String key){
        return incrByDouble(client, key, 1D);
    }

    public static double incrByDouble(ShardedJedis client, String key, double amount){
        assertClient(client);
        assertKey(key);

        return client.incrByFloat(key, amount);
    }

    public static double decrByDouble(ShardedJedis client, String key){
        return incrByDouble(client, key, -1D);
    }

    public static double decrByDouble(ShardedJedis client, String key, double amount){
        return incrByDouble(client, key, -amount);
    }

    private static void assertClient(ShardedJedis client){
        AssertUtils.notNull(client, "client client must not be null");
    }

    private static void assertKey(String key){
        AssertUtils.isNotBlank(key, "redis key must not be null");
    }

    private static boolean notNullValue(String value){
        return StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value);
    }

    private static String getValue(Object value){
        AssertUtils.notNull(value, "redis value must not be null");

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
