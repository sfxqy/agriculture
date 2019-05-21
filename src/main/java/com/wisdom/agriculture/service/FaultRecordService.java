package com.wisdom.agriculture.service;


import com.wisdom.agriculture.dao.AbnormalMapper;
import com.wisdom.agriculture.pojo.FaultRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultRecordService {


    @Autowired
    private AbnormalMapper abnormalMapper;

    public List<FaultRecord> getFaultInfo(){
        return abnormalMapper.getFaultInfo();
    }


    public void deleteFault(Integer id){

    }


}
