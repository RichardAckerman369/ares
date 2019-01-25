package com.clown.ares.service.impl;

import com.clown.ares.entity.Department;
import com.clown.ares.mapper.DepartmentMapper;
import com.clown.ares.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    @Override
    public Department findById(Long departmentId) {
        return departmentMapper.findById(departmentId);
    }

    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public void delete(Long departmentId) {
        departmentMapper.delete(departmentId);
    }
}
