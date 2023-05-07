package com.itheima.dto;

import com.itheima.entity.Checkgroup;
import com.itheima.entity.Checkitem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class CheckgroupDto extends Checkgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Checkitem> checkItems;

}
