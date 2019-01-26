package com.clown.ares.client;

import com.clown.ares.entity.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ARES-PROVIDER")
public interface DepartmentClient {
    @GetMapping("/department/findAll")
    List<Department> findAll();

    @GetMapping("/department/findById/{departmentId}")
    Department findById(@PathVariable("departmentId") Long departmentId);

    @PostMapping("/department/add")
    String add(@RequestBody Department department);

    @PutMapping("/department/update")
    String update(@RequestBody Department department);

    @DeleteMapping("/department/delete/{departmentId}")
    String delete(@PathVariable("departmentId") Long departmentId);

    @GetMapping("/department/discovery")
    Object discovery();
}
