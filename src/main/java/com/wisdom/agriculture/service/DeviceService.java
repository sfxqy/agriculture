package com.wisdom.agriculture.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.dao.DetailsMapper;
import com.wisdom.agriculture.dao.DeviceMapper;
import com.wisdom.agriculture.exception.BusinessException;
import com.wisdom.agriculture.pojo.DetailsVo;
import com.wisdom.agriculture.pojo.Device;
import com.wisdom.agriculture.pojo.Dtype;
import com.wisdom.agriculture.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SFX
 */

@Service
public class DeviceService {

    private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);

    @Autowired
    private DeviceMapper deviceMapper;


    @Autowired
    private DetailsMapper detailsMapper;

    public void addDtype(String name)throws Exception{
        CheckUtil.isNull(name);
        logger.info("数据添加中... 参数{}",name);
        if (deviceMapper.getDtypeByName(null,name)==null)
            deviceMapper.addDtype(name);
        else {

                logger.info("[该类型已存在]");
                throw new BusinessException("该类型已存在");

        }
    }



    public void deleteDtype(String tid){
        logger.info("开始删除...  参数 {}",tid);
        String tid1[]=tid.split(",");
        logger.info("执行删除操作  参数 {}",tid1);
        for (int i=0;i<tid1.length;i++){
            Integer tid2=Integer.parseInt(tid1[i]);
            if (deviceMapper.getDtypeByName(tid2,null)!=null)
                deviceMapper.deleteDtype(tid2);
            else {
                try {
                    logger.info("[不存在该类型]");
                    throw new BusinessException("不存在该类型");
                }catch (Exception e){

                }
            }
        }


    }



    public PageInfo<Dtype> getAllDeviceType(Integer pageNum, Integer pageSize){
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        logger.info("[查询设备类型信息]");
        PageHelper.startPage(pageNum, pageSize);
        List<Dtype> dtypes= deviceMapper.getAllDtype(null,null);
        return new PageInfo<Dtype>(dtypes);
    }




    public PageInfo<Device> getDeviceByCondition(Integer deid, Integer deviceid, String devicename, String appkey,
                                                 Integer online, String place, Integer pageSize, Integer pageNum)throws Exception{

        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        logger.info("[查询设备信息] {} {} {} {} {} {} {} {}", deid, deviceid, devicename, appkey, online, place, pageSize, pageNum);
        PageHelper.startPage(pageNum, pageSize);
        List<Device> devices=deviceMapper.getDeviceByCondition(deid,deviceid,devicename,appkey,online,place);
        if(devices.size()==0){
            throw new BusinessException("未查询到相关数据");
        }
        return new PageInfo<Device>(devices);
    }


    //-----设备表相关操作-----------------


    /**
     * 添加设备数据
     * @param deviceName
     * @param appkey
     * @param longitude
     * @param latitude
     * @param place
     * @throws Exception
     */
    public void addDevice(Integer deviceid,String deviceName,String appkey,Float longitude,Float latitude,String place)throws Exception{
        CheckUtil.isNull(deviceName,appkey,longitude,latitude,place);
        logger.info("接口添加中... 参数 {} {} {} {} {} {}", deviceid, deviceName, appkey, longitude, latitude, place);
        int row=deviceMapper.getDeviceByCondition(null,deviceid,null,null,null,null).size();
        logger.info("row {}",row);

        if (row!=0){
            logger.info("该编号已存在");
            throw new BusinessException("该编号已存在");
        }
        logger.info("数据添加中 参数{} {} {} {}",deviceName,appkey,longitude,latitude,place);
        deviceMapper.addDevice(deviceid,deviceName,appkey,0,longitude,latitude,place);
        logger.info("数据成功");
    }


    /**
     * 删除设备
     * @param deviceId
     */
    public void deleteDevice(String deviceId)throws Exception{
        logger.info("开始删除...  参数 {}",deviceId);
        String deviceId1[]=deviceId.split(",");
        logger.info("执行删除操作  参数 {}",deviceId1);
        logger.info("删除数据中 参数{}",deviceId);
        for(int i=0;i<deviceId1.length;i++){
            Integer deviceId2=Integer.parseInt(deviceId1[i]);
            int row=deviceMapper.getDeviceByCondition(null,deviceId2,null,null,null,null).size();
            logger.info("row {}",row);
            if (row==0){
                throw new BusinessException("该设备已在其他账号中被删除");
            }else {
                deviceMapper.deleteDevice(deviceId2);
            }

        }



        logger.info("删除成功");
    }


    /**
     * 修改设备信息
     * @param deviceId
     * @param deviceName
     * @param appkey
     * @param longitude
     * @param latitude
     * @param place
     */
    public void updataDevice(Integer deviceId,String deviceName,String appkey,Float longitude,Float latitude,String place)throws Exception{
        CheckUtil.isNull(deviceId,deviceName,appkey,longitude,latitude,place);
        logger.info("数据修改中 参数{} {} {} {}",deviceName,appkey,longitude,latitude,place);
        deviceMapper.updataDevice(deviceId, deviceName, appkey, longitude, latitude, place);
        logger.info("修改成功");
    }



    //--传感器----------------------------------

    /**
     * 添加传感器信息
     * @param deviceId
     * @param tid
     * @param max
     * @param min
     * @param warnmax
     * @param warnmin
     */
    public void addDetails(Integer deviceId,Integer tid,float max,float min,float warnmax,float warnmin)throws Exception{
        CheckUtil.isNull(deviceId,tid,max,min,warnmax,warnmin);
        logger.info("添加传感器数据 参数{} {} {} {} {} {}",deviceId,tid,max,min,warnmax,warnmin);
        deviceMapper.addDetails(deviceId,tid,max,min,warnmax,warnmin);
        logger.info("数据添加成功");
    }


    /**
     * 删除传感器信息
     * @param did
     * @throws Exception
     */
    public void deleteDetails(String did)throws Exception{
        CheckUtil.isNull(did);
        logger.info("开始删除...  参数 {}",did);
        String did1[]=did.split(",");
        logger.info("执行删除操作  参数 {}",did1);
        logger.info("删除数据中 参数{}",did1);
        for(int i=0;i<did1.length;i++){
            Integer did2=Integer.parseInt(did1[i]);
            int row=  detailsMapper.getDetailsByCondition(did2,null,null).size();
            logger.info("row {}",row);
            if (row==0){
                logger.info("该采集器已在其他账号中被删除 采集器编号{}",did2);
                throw new BusinessException("该采集器已在其他账号中被删除");
            }else {
                deviceMapper.deleteDetails(did2);
            }

        }
        logger.info("删除成功");

    }


    public void updateDetails(Integer did,Integer deviceId,Integer tid,float max,float min,float warnmax,float warnmin)throws Exception{
        CheckUtil.isNull(did,deviceId,tid,max,min,warnmax,warnmin);
        logger.info("修改传感器数据 参数{} {} {} {} {} {} {}",did,deviceId,tid,max,min,warnmax,warnmin);
        deviceMapper.updateDetails(did,deviceId,tid,max,min,warnmax,warnmin);
        logger.info("数据修改成功");
    }


    public PageInfo<DetailsVo> getDetailsInfo(Integer did, Integer deviceid, Integer tid, Integer pageNum, Integer pageSize)throws Exception{
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        logger.info("[查询采集器信息] {}", did);
        PageHelper.startPage(pageNum, pageSize);
        List<DetailsVo>  detailsVos= detailsMapper.getDetailsByCondition(did,deviceid,tid);
        if (detailsVos.size()==0){
            logger.info("[未查询到相关信息");
            throw new BusinessException("未查询到相关信息");
        }
        return new PageInfo<DetailsVo>(detailsVos);
    }


}
