package com.clown.ares.service;

import com.clown.ares.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findById(Long departmentId);

    void add(Department department);

    void update(Department department);

    void delete(Long departmentId);
}
