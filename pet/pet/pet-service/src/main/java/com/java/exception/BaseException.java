package com.java.exception;


import com.java.result.ResultEnum;

/**
 * 通用异常的处理
 * @author pet.team
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 456123064123123L;

    public BaseException() {}

    /**
     * 一个返回状态枚举的构造函数
     * @param resultEnum
     */
    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
        this.errorCode = resultEnum.getCode();
        this.errorMessage = resultEnum.getMsg();
    }

    /**
     * 返回信息枚举
     */
    private ResultEnum resultEnum;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;


    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
