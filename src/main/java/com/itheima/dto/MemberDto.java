package com.itheima.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class MemberDto implements Serializable {
    private static final long serialVersionUID = 1L;
    String username;
    String idcard;
    String phonenumber;
    String setmealname;
    String remark;
    String img;
    String ordertype;
    Date orderdate;
    String orderdate1;
}
