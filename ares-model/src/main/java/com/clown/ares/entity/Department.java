package com.clown.ares.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Department implements Serializable {

    private Long    departmentId;           //主键ID
    private String  departmentName;         //部门名称
    private String  db_source;              //来自于那一个数据库:微服务机构可以一个微服务一个库,同一微服务信息可以存储到不同的库

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
