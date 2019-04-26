package com.small.leaf.service.common.exception;


/**
 * @Author: yefan
 * @Date: 2019/4/26 11:23 AM
 */
public class CoreServiceException extends RuntimeException {
    private int excepType;
    private String excepDesc;

    public CoreServiceException() {
        super();
    }

    public CoreServiceException(String message) {
        super(message);
        this.excepDesc = excepDesc;
    }

    public CoreServiceException(int excepType, String excepDesc) {
        super(excepDesc);
        this.excepType = excepType;
        this.excepDesc = excepDesc;
    }

    public int getExcepType() {
        return excepType;
    }


    public String getExcepDesc() {
        return excepDesc;
    }

}
