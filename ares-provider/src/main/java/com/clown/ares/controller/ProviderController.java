package com.clown.ares.controller;

import com.clown.ares.entity.Department;
import com.clown.ares.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@RestController
@RequestMapping("/department")
public class ProviderController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/findAll")
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/findById/{departmentId}")
    public Department findById(@PathVariable Long departmentId){
        return departmentService.findById(departmentId);
    }

    @PostMapping("/add")
    public String add(@RequestBody Department department){
        try {
            departmentService.add(department);
            return "添加成功";
        } catch (Exception e) {
            return "添加失败";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Department department){
        try {
            departmentService.update(department);
            return "更新成功";
        } catch (Exception e) {
            return "更新失败";
        }
    }


    @DeleteMapping("/delete/{departmentId}")
    public String delete(@PathVariable("departmentId") Long departmentId){
        try {
            departmentService.delete(departmentId);
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("******"+services);

        List<ServiceInstance> instances = discoveryClient.getInstances("zeus-provider");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
