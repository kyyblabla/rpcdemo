package com.kyyblabla.rpcframework.dto;

import lombok.Data;

/**
 * Created by kyy on 2017/3/3.
 */
@Data
public class RpcResponse {
    private String requestId;
    private Throwable error;
    private Object result;

    public boolean isError() {
        return error != null;
    }
}
