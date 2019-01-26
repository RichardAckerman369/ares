package com.clown.ares.service;

import com.clown.ares.entity.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 **/
@Component      //不要忘记这个注解
public class DepartmentClientServiceFallBackMethod implements FallbackFactory<DepartmentClientService> {

    @Override
    public DepartmentClientService create(Throwable throwable) {
        return new DepartmentClientService() {
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
        };
    }
}
