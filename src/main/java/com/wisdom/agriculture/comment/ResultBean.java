package com.wisdom.agriculture.comment;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

/**
 * @author SFX
 * 消息类：所有返回数据封装到该类
 */
@Data
@Getter
@Setter
public class ResultBean {

    private static final boolean SUCCESS=true;

    private static final boolean FAIL=false;

    private boolean state;

    private Integer code;

    private String msg;

    //private Object data;

    private String username;

    private Integer userid;

    private Integer total;

    private Object rows;


    public void setUserInfo(){
        this.username=User.getUsername();
        this.userid=User.getId();
    }


    public ResultBean() {
        this.state=SUCCESS;
        this.msg="操作成功";
        setUserInfo();
    }




    public ResultBean(String msg,boolean state) {
        this.state = state;
        this.msg = msg;
        setUserInfo();
    }



    public ResultBean(String msg, Object rows) {
        this.state = SUCCESS;
        this.msg = msg;
        this.rows = rows;
        if (rows instanceof Collection)
            this.total=((Collection) rows).size();
        setUserInfo();
    }


    public ResultBean(Object rows) {
        this.state = SUCCESS;
        this.msg = "操作成功";
        this.rows = rows;
        if (rows instanceof Collection)
            this.total=((Collection) rows).size();
        setUserInfo();
    }

    public ResultBean( String msg, Object rows,boolean state) {
        this.state = state;
        this.msg = msg;
        this.rows = rows;
        if (rows instanceof Collection)
            this.total=((Collection) rows).size();
        setUserInfo();
    }


    public ResultBean(Throwable e) {
        this.msg = e.toString();
        this.state = FAIL;
        setUserInfo();
    }


}
