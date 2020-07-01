package com.wisdom.agriculture.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.dao.WarningMapper;
import com.wisdom.agriculture.exception.BusinessException;
import com.wisdom.agriculture.pojo.Customer;
import com.wisdom.agriculture.pojo.Data;
import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.WarningVo;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarningService {

    private static final Logger logger = LoggerFactory.getLogger(WarningService.class);

    @Autowired
    private WarningMapper warningMapper;


    /**
     * 分页查询预警数据
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public Object[] getAllWarn(Integer pageNum, Integer pageSize)throws Exception{
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        Object[] obj=new Object[2];
        List<Details> details=new ArrayList<>();
        List<WarningVo> warningVo=new ArrayList<>();
        List<Integer> allDid=warningMapper.getAllDid();
        logger.info("获取所有did参数 {} {}",allDid.size(),allDid);
        for (int i=0;i<allDid.size();i++){
            Details details1=warningMapper.getDetailsByDid(allDid.get(i));
            if (details1!=null){
                details.add(details1);
            }
            logger.info("获取所有details参数 {} {}",details.size(),details);
        }
        for (Details d:details){
            List<WarningVo> warningVos=warningMapper.getWarningVo(d.getDid(),d.getWarnmin(),d.getWarnmax());
            logger.info("获取所有预警参数WarningVo {} {} {} {} {} ",d.getDid(),d.getWarnmax(),d.getWarnmin(),warningVos.size(),warningVos);
            if (warningVos.size()!=0)
             warningVo.addAll(warningVos);
        }
        if (warningVo==null){
            logger.info("暂无相关数据");
            throw new BusinessException("暂无相关数据");
        }
        int start=(pageNum-1)*pageSize;
        int end=pageNum*pageSize;
        if (end>warningVo.size()-1)
            end=warningVo.size();

        obj[0]=warningVo.subList(start,end);
        obj[1]=warningVo.size();
        logger.info("开始{}   结束{}   数据量{}",start,end,warningVo.size());
        return  obj;
    }
}
