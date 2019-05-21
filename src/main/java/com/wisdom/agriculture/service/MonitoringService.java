package com.wisdom.agriculture.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.dao.MonitoringMapper;
import com.wisdom.agriculture.exception.BusinessException;
import com.wisdom.agriculture.pojo.Monitoring;
import com.wisdom.agriculture.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringService {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringService.class);

    @Autowired
    private MonitoringMapper monitoringMapper;


    /**
     * 获取视频流地址
     * @param id 摄像码
     * @return
     */
    public List<String> getIpAddress(Integer id){
        logger.info("正在获取视频流地址...");
        List<Monitoring> monitoring=monitoringMapper.getMonitoring(id);
        List<String> monitorings=null;
        for (Monitoring m:monitoring){
            monitorings.add(m.getIp()+"//"+m.getAid());
        }
        logger.info("视频流地址获取成功");
        return monitorings;
    }


    /**
     * 根据条件获取监控摄像头信息
     * @param did
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Monitoring> getInfoByConditions(Integer did,Integer pageNum,Integer pageSize)throws Exception{
        logger.info("获取参数 {} {} {}",did,pageNum,pageSize);
        logger.info("正在查询中...");
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Monitoring> monitoringList=monitoringMapper.getMonitoring(did);
        if (monitoringList.size()==0){
            logger.info("[未查询到相关数据]");
            throw new BusinessException("未查询到相关数据");
        }
        logger.info("查询成功");
        return new PageInfo<Monitoring>(monitoringList);
    }

    /**
     * 修改监控信息
     * @param monitoring
     */
    public void updataMon(Monitoring monitoring){
        logger.info("正在修改监控信息...");
        monitoringMapper.updataMon(monitoring);
        logger.info("修改成功");
    }


    /**
     * 添加视频监控信息
     * @param monitoring
     * @throws Exception
     */
    public void addMonitoring(Monitoring monitoring)throws Exception{
        logger.info("添加参数 {} {}",monitoring.getAid(),monitoring.getIp());
        CheckUtil.isNull(monitoring.getAid(),monitoring.getIp());
        logger.info("添加视频监控信息中");
        int row=monitoringMapper.addMonitoring(monitoring);
        if (row==0){
            logger.info("系统异常，请重试");
            throw new BusinessException("系统异常，请重试");
        }
        logger.info("信息添加成功");

    }


    /**
     * 删除视频监控信息
     * @param id
     * @throws Exception
     */
    public void deleteMonitoring(String id)throws Exception{
        CheckUtil.isNull(id);
        String id1[]=id.split(",");
        logger.info("删除信息中");
        for (int i=0;i<id1.length;i++){
            int id2=Integer.parseInt(id1[i]);
            int row=monitoringMapper.deleteMonitoring(id2);
            if (row==0){
                logger.info("系统异常，请重试");
                throw new BusinessException("系统异常，请重试");
            }
        }

        logger.info("监控信息删除成功");
    }
}
