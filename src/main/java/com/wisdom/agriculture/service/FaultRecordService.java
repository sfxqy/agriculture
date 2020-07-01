package com.wisdom.agriculture.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.dao.AbnormalMapper;
import com.wisdom.agriculture.dao.DataMapper;
import com.wisdom.agriculture.dao.DetailsMapper;
import com.wisdom.agriculture.dao.FaultMapper;
import com.wisdom.agriculture.pojo.Abnormal;
import com.wisdom.agriculture.pojo.Data;
import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.FaultRecord;
import com.wisdom.agriculture.utils.CheckUtil;
import com.wisdom.agriculture.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class FaultRecordService {

    private static final Logger logger = LoggerFactory.getLogger(FaultRecordService.class);

    @Autowired
    private AbnormalMapper abnormalMapper;

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private DetailsMapper detailsMapper;

    @Autowired
    private FaultMapper faultMapper;

    public List<FaultRecord> getFaultInfo(){
        List<Integer>  did=dataMapper.getAllDid();
        for (Integer d:did){
            Details details=detailsMapper.getDetails(d,null,null).get(0);
            List<Data> dataList=dataMapper.getFault(details.getDid(),details.getMax(),details.getMin());
            for (Data data:dataList){
                Abnormal abnormal=faultMapper.getDaid(data.getDaid());
                if (abnormal!=null)continue;
                faultMapper.addFault(d,data.getDaid());
            }
        }
        return abnormalMapper.getFaultInfo();
    }


    public PageInfo<FaultRecord> getFaultRecord(Integer pageNum,Integer pageSize){
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<FaultRecord>  faultRecords=faultMapper.getAllFault();
        return new PageInfo<FaultRecord>(faultRecords);
    }


    public void deleteFault(String id)throws Exception{
        CheckUtil.isNull(id);
        logger.info("执行删除操作  参数{}",id);
        String id1[]=id.split(",");
        for (int i=0;i<id1.length;i++){
            faultMapper.deleteByid(Integer.parseInt(id1[i]));
        }

    }


    public void getExcel(HttpServletResponse response){
        List<FaultRecord>  faultRecords=faultMapper.getAllFault();
        String[] title=new String[]{"故障数据编号","采集器编号","所属设备编号","所属设备名称","经度","纬度","传感器地址","故障时间"};
        FileUtil.getHSSFWorkbook1(title,faultRecords,response,"故障工单");
    }


}
