package com.zyh.zyhTest.exception;


import com.zyh.zyhTest.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/6/28/0028.
 */
@Getter
@Setter
public class AppFrontException extends RuntimeException{

    private String errorCode;

    public AppFrontException(ResponseEnum responseEnum){
        super(responseEnum.getErrorMsg());
        this.errorCode = responseEnum.getErrorCode();
    }

}
