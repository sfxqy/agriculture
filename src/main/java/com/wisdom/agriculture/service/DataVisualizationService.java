package com.wisdom.agriculture.service;


import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.dao.DataVisualizationMapper;
import com.wisdom.agriculture.pojo.Device;
import com.wisdom.agriculture.pojo.Dtype;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataVisualizationService {

    private static final Logger logger = LoggerFactory.getLogger(DataVisualizationService.class);

    @Autowired
    private DataVisualizationMapper dataVisualizationMapper;


    public List<Dtype> getDeviceType(){
        logger.info("[开始查询采集器类型及其数量]");
        return dataVisualizationMapper.getDeviceType();
    }




    public List<Device> getDeviceSituation(){
        return dataVisualizationMapper.getOnline();
    }

}
