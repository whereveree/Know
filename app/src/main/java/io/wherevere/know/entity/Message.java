package io.wherevere.know.entity;

public class Message {

    /**
     * errorCode : 0
     * errorMsg : null
     * data : jj
     */

    private int errorCode;
    private Object errorMsg;
    private Object data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
