package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String msg;


    public static Result success(String msg) {
        return new Result(200, null, msg);
    }

    public static Result success(Object data,String msg) {
        return new Result(200, data, msg);
    }

    public static Result fail(String msg) {
        return new Result(400, null, msg);
    }


}
