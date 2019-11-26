package cn.shineiot.base.base;

/**
 * @author GF63
 * 所有javabean的基类，包含返回的公共属性
 */

public class BaseResult<T> {

    private static final long serialVersionUID = 1L;
    private String errorMsg ;
	private int errorCode;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
