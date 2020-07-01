package com.wisdom.agriculture.utils;


import com.wisdom.agriculture.dao.DataMapper;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;
import java.util.Set;

@Component(value = "redisUtils")
public class RedisUtils {


     @Resource
     RedisTemplate<String, Object> redisTemplate;

/*    @Resource
    private JedisPool jedisPool;*/


    @Autowired
    private DataMapper dataMapper;


    /**
     * 从redis中取出所有的采集器数据
     * @return
     */
    public HashMap<String,Float> getAllValue(){
        Set<String> keys=redisTemplate.keys("*");
        HashMap<String,Float>  map=new HashMap<>();
        for (String key:keys){
            String value=redisTemplate.opsForValue().get(key).toString();
            Float value1=Float.parseFloat(value);
            map.put(key,value1);
        }
        return map;
    }


    /**
     * 获取redis中数据的数据量
     * @return
     */
    public Integer getNum(){
        Set<String> keys=redisTemplate.keys("*");
        System.out.println(keys==null);

        if (keys==null)
            return 0;
        return keys.size();
    }


    /**
     * 获取某个key的值
     * @param key
     * @return
     */
    public Object get(String key) {
        if (StringUtils.isEmpty(key)) {
             return null;
            }
            return redisTemplate.opsForValue().get(key);
     }


    /**
     * 向缓存中添加数据
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
         if (StringUtils.isEmpty(key)) {
              return;
         }
         redisTemplate.opsForValue().set(key,value);
     }


    /**
     * 删除redis中所有的缓存数据
     */
    public void removeAllValue(){
         HashMap<String,Float> map=getAllValue();
         for (Map.Entry<String, Float> entry : map.entrySet()) {
             String key=entry.getKey();
             delete(key);
         }
     }


    /**
     *
     * @return
     */
     public Integer getValueNum(){
        return (Integer) redisTemplate.opsForValue().get("Num");
     }


     //增加采集器数据量
     public void setValueNum(Integer n){
         Integer Num=getValueNum();
        if (n==0){
            Num=0;
        }else {
            Num++;
        }
         redisTemplate.opsForValue().set("Num",Num);
     }






    /**
     * 更新缓存
     */
     public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     */
     public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
