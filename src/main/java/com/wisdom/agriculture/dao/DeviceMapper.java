package com.wisdom.agriculture.dao;

import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.Device;
import com.wisdom.agriculture.pojo.Dtype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper {



    void addDtype(@Param("type") String type);


    Dtype getDtypeByName(@Param("tid") Integer tid,@Param("type") String type);

    List<Dtype> getAllDtype(@Param("tid") Integer tid,@Param("type") String type);


    List<Device> getDeviceByCondition(@Param("deid") Integer deid,
                                      @Param("deviceid") Integer deviceid,
                                      @Param("devicename") String devicename,
                                      @Param("appkey") String appkey,
                                      @Param("online") Integer online,
                                      @Param("place") String place);



    void deleteDtype(@Param("tid") Integer tid);


    void addDevice(@Param("deviceid") Integer deviceid,
                   @Param("devicename") String devicename,
                   @Param("appkey") String appkey,
                   @Param("online") Integer online,
                   @Param("longitude") float longitude,
                   @Param("latitude") float latitude,
                   @Param("place") String place);


    void deleteDevice(@Param("deviceId") Integer deviceId);


    void updataDevice(@Param("deviceId") Integer deviceId,
                 @Param("devicename") String devicename,
                 @Param("appkey") String appkey,
                 @Param("longitude") float longitude,
                 @Param("latitude") float latitude,
                 @Param("place") String place);


    void addDetails(   @Param("deviceId") Integer deviceId,
                       @Param("tid") Integer tid,
                       @Param("max") float max,
                       @Param("min") float min,
                       @Param("warnmax") float warnmax,
                       @Param("warnmin") float warnmin);


    void deleteDetails(@Param("did") Integer did);


    void updateDetails(   @Param("did") Integer did,
                        @Param("deviceId") Integer deviceId,
                        @Param("tid") Integer tid,
                        @Param("max") float max,
                        @Param("min") float min,
                        @Param("warnmax") float warnmax,
                        @Param("warnmin") float warnmin);



    List<Details> getDetailsInfo(@Param("did") Integer did);
}
