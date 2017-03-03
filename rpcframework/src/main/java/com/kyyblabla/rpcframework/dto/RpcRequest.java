package com.kyyblabla.rpcframework.dto;

import lombok.Data;

/**
 * Created by kyy on 2017/3/3.
 */
@Data
public class RpcRequest {

    private String requestId;
    private String className;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

}
