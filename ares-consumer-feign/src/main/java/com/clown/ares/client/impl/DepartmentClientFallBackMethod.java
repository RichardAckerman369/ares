package com.clown.ares.client.impl;

import com.clown.ares.client.DepartmentClient;
import com.clown.ares.entity.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 **/
@Component
@Service
public class DepartmentClientFallBackMethod implements DepartmentClient {
    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department findById(Long departmentId) {
        return new Department()
                .setDepartmentId(departmentId)
                .setDepartmentName("该ID: "+departmentId+" 没有对应的信息")
                .setDb_source("该ID: "+departmentId+" 没有对应的数据库");
    }

    @Override
    public String add(Department department) {
        return "服务忙,请稍后再试!!!";
    }

    @Override
    public String update(Department department) {
        return "服务忙,请稍后再试!!!";
    }

    @Override
    public String delete(Long departmentId) {
        return "服务忙,请稍后再试!!!";
    }

    @Override
    public Object discovery() {
        return "没有查询到数据";
    }
}
