package com.clown.ares.controller;

import com.clown.ares.client.DepartmentClient;
import com.clown.ares.entity.Department;
import com.clown.ares.service.DepartmentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@RestController
@RequestMapping("/consumer/feign/department")
public class DepartmentController {

    @Autowired
    private DepartmentClientService departmentClientService;

    @Autowired
    private DepartmentClient departmentClient;

    @GetMapping("/findAll")
    public List<Department> findAll(){
        return departmentClient.findAll();
//        return departmentClientService.findAll();
    }

    @GetMapping("/findById/{departmentId}")
    public Department findById(@PathVariable("departmentId") Long departmentId){
        return departmentClient.findById(departmentId);
//        return departmentClientService.findById(departmentId);
    }

    @PostMapping("/add")
    public String add(@RequestBody Department department){
        return departmentClient.add(department);
//        return departmentClientService.add(department);
    }

    @PutMapping("/update")
    public String update(@RequestBody Department department){
        return departmentClient.update(department);
//        return departmentClientService.update(department);
    }

    @DeleteMapping("/delete/{departmentId}")
    public String delete(@PathVariable("departmentId") Long departmentId){
        return departmentClient.delete(departmentId);
//        return departmentClientService.delete(departmentId);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return departmentClient.discovery();
//        return departmentClientService.discovery();
    }
}
