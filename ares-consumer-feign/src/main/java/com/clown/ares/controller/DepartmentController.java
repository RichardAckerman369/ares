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
//        return departmentClientService.findAll();
        return departmentClient.findAll();
    }

    @GetMapping("/findById/{departmentId}")
    public Department findById(@PathVariable("departmentId") Long departmentId){
//        return departmentClientService.findById(departmentId);
        return departmentClient.findById(departmentId);
    }

    @PostMapping("/add")
    public String add(@RequestBody Department department){
//        return departmentClientService.add(department);
        return departmentClient.add(department);
    }

    @PutMapping("/update")
    public String update(@RequestBody Department department){
//        return departmentClientService.update(department);
        return departmentClient.update(department);
    }

    @DeleteMapping("/delete/{departmentId}")
    public String delete(@PathVariable("departmentId") Long departmentId){
//        return departmentClientService.delete(departmentId);
        return departmentClient.delete(departmentId);
    }

    @GetMapping("/discovery")
    public Object discovery(){
//        return departmentClientService.discovery();
        return departmentClient.discovery();
    }
}
