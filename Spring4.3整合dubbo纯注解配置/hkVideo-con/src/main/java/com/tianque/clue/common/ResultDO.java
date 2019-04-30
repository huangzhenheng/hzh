package com.tianque.clue.common;

/**
 * @author hzh
 * @create 2019-04-28 15:03
 */
import java.io.Serializable;

public class ResultDO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 执行是否成功 */
    private boolean success;

    private String errCode;

    private String errDesc;

    /** 实际的返回结果 */
    private T module;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    public void setModuleWithSuccess(T module) {
        this.module = module;
        setSuccess(true);

    }

    public void setErr(String errCode, String errDesc) {
        setErrCode(errCode);
        setErrDesc(errDesc);
        setSuccess(false);
    }

    public String toErrorString() {
        if (errCode == null && errDesc == null) {
            return "no  error info";
        } else {
            return "errCode:" + errDesc + ", errDesc:" + errDesc;
        }
    }
}
