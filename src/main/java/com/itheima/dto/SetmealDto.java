package com.itheima.dto;

import com.itheima.entity.Setmeal;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class SetmealDto extends Setmeal implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CheckgroupDto> checkGroups;
}
