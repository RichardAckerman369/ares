package com.clown.ares.controller;

import com.clown.ares.entity.Department;
import com.clown.ares.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findAll")
    @HystrixCommand(fallbackMethod = "findAllFallBackMethod")
    public List<Department> findAll(){
        List<Department> departmentList = departmentService.findAll();
        if (null == departmentList) {
            throw new RuntimeException("服务忙,请稍后再试!!!!");
        }
        return departmentList;
    }

    //查询所有断路器方法
    private List<Department> findAllFallBackMethod(){
        return null;
    }

    @GetMapping("/findById/{departmentId}")
    @HystrixCommand(fallbackMethod = "findByIdFallBackMethod")
    public Department findById(@PathVariable Long departmentId){
        Department department = this.departmentService.findById(departmentId);
        if (null == department) {
            throw new RuntimeException("该ID: "+departmentId+" 没有对应的信息");
        }
        return department;
    }

    //查询一个断路器方法
    private Department findByIdFallBackMethod(@PathVariable Long departmentId){
        return new Department()
                .setDepartmentId(departmentId)
                .setDepartmentName("该ID: "+departmentId+" 没有对应的信息")
                .setDb_source("该ID: "+departmentId+" 没有对应的数据库");
    }

    @PostMapping("/add")
    public String add(@RequestBody Department department){
        try {
            departmentService.add(department);
            return "添加成功";
        } catch (Exception e) {
            return "服务器忙,请稍后重试!!!";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Department department){
        try {
            departmentService.update(department);
            return "更新成功";
        } catch (Exception e) {
            return "服务器忙,请稍后重试!!!";
        }
    }

    @DeleteMapping("/delete/{departmentId}")
    public String delete(@PathVariable("departmentId") Long departmentId){
        try {
            departmentService.delete(departmentId);
            return "删除成功";
        } catch (Exception e) {
            return "服务器忙,请稍后重试!!!";
        }
    }
}
