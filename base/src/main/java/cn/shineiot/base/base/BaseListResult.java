package cn.shineiot.base.base;

import java.util.List;

/**
 * @author GF63
 * 所有javabean的基类，包含返回的公共属性
 */

public class BaseListResult<T> {

    private static final long serialVersionUID = 1L;
    private String errorMsg ;
    private int errorCode ;
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
