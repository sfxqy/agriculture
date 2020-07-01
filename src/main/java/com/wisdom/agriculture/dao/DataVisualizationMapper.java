package com.wisdom.agriculture.dao;

import com.wisdom.agriculture.pojo.Device;
import com.wisdom.agriculture.pojo.Dtype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataVisualizationMapper {


    List<Dtype> getDeviceType();


    List<Device> getOnline();
}
