package com.wisdom.agriculture.dao;


import com.wisdom.agriculture.pojo.Monitoring;
import com.wisdom.agriculture.pojo.MonitoringExample;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MonitoringMapper {
    int countByExample(MonitoringExample example);

    int deleteByExample(MonitoringExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Monitoring record);

    int insertSelective(Monitoring record);

    List<Monitoring> selectByExample(MonitoringExample example);

    Monitoring selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Monitoring record, @Param("example") MonitoringExample example);

    int updateByExample(@Param("record") Monitoring record, @Param("example") MonitoringExample example);

    int updateByPrimaryKeySelective(Monitoring record);

    int updateByPrimaryKey(Monitoring record);



    List<Monitoring> getMonitoring(@Param("id") Integer id);

    void updataMon(Monitoring monitoring);

    int addMonitoring(Monitoring monitoring);

    int deleteMonitoring(@Param("id") Integer id);
}