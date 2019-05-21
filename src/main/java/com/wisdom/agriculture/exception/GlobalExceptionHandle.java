package com.wisdom.agriculture.exception;


import com.wisdom.agriculture.comment.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * @author SFX
 * 全局异常捕获
 */

@ControllerAdvice
public class GlobalExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    /**
     * 验证类异常，空
     * @param exception
     * @return
     */
    @ExceptionHandler(CheckException.class)
    @ResponseBody
    public ResultBean customGenericExceptionHnadler(CheckException exception) {
        return new ResultBean(exception.getLocalizedMessage(),false);
    }

    /**
     * 业务处理异常
     * @param exception
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultBean businessExceptionExceptionHnadler(BusinessException exception) {
        return new ResultBean(exception.getLocalizedMessage(),false);
    }



/*    public HashMap<String,Object> PagingExceptionHnadler(PagingException exception){
        hashMap.put("state",true);
        hashMap.put("msg","添加成功");
        hashMap.put("total",pageInfo.getTotal());
        hashMap.put("rows",pageInfo.getList());
        return hashMap;
    }*/




    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new ResultBean(e.getLocalizedMessage(),false);
    }

}
