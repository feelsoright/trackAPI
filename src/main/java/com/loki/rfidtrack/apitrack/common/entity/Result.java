package com.loki.rfidtrack.apitrack.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Loki.C
 * @date:Created in 2019/2/8 15:37
 * @description: jsonToEntity
 * @modified by:
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 是否成功
     */
    private boolean flag;
    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String massage;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 状态构造
     * @param flag
     * @param code
     */
    public Result(boolean flag,int code){
        this.flag = flag;
        this.code = code;
    }

    /**
     * 是用于增删改构造
     * @param flag
     * @param code
     * @param massage
     */
    public Result(boolean flag,int code,String massage){
        this.flag = flag;
        this.code = code;
        this.massage = massage;
    }
}
