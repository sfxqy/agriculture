package com.wisdom.agriculture.service;


import com.wisdom.agriculture.dao.DataMapper;
import com.wisdom.agriculture.dao.DetailsMapper;
import com.wisdom.agriculture.dao.DeviceMapper;
import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.Device;
import com.wisdom.agriculture.utils.RedisUtils;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("redisService")
public class RedisService {

    @Autowired
    RedisUtils redisUtils;


    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DetailsMapper detailsMapper;


    @Autowired
    private DataMapper dataMapper;




    public void addDetails(){
        List<Device> devices=deviceMapper.getDeviceByCondition(null,null,null,null,null,null);
        for (Device d:devices){
            List<Details> details=detailsMapper.getDetails(null,d.getDeviceid(),null);
            redisUtils.set(d.getDeviceid().toString(),devices);
        }
    }


    /**
     * 获取redis中数据的量
     * @return
     */
    public Integer getNum(){

        System.out.println("redis数据量:"+redisUtils.getNum());
        return redisUtils.getNum();
    }

    /**
     * 持久化数据
     */
    public void persistence(){
        List<Details> detailsList=detailsMapper.getDetails(null,null,null);
        List<Integer> did=new ArrayList<>();
        for (Details d:detailsList)
            did.add(d.getDid());
        Map<String,Float> map=redisUtils.getAllValue();
        for (Map.Entry<String, Float> entry : map.entrySet()) {
                String key=entry.getKey();
                Float value=entry.getValue();
                String[] k=key.split("&");
                Date date =null;
                //java.sql.Date date1=null;
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {


                    date = formatter.parse((String) k[1]);
                 //   date1=new java.sql.Date(date.getTime());

                }catch (Exception e){}
                System.out.println(Integer.parseInt(k[0])+"==="+value+"==="+date);
                dataMapper.addValue(Integer.parseInt(k[0]),value,date);
        }
    }


    public Object getValueByKey(String key){
        return  redisUtils.get(key);
    }


    public void setValue(String key,Object obj){
        redisUtils.set(key,obj);
    }




    public void removeValue(){
        redisUtils.removeAllValue();
    }


    public void removeAllValue(){

    }





}
