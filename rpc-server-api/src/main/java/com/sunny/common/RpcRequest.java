package com.sunny.common;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Description TODO
 * @Version 1.0
 * @Author ChenKun
 * @Date 2019-09-19 15:49
 * @ModifyDate 2019-09-19 15:49
 */
public class RpcRequest implements Serializable {
    private String className;

    private String methodName;

    private Object[] params;

    @Override
    public String toString() {
        return "RpcRequest{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
