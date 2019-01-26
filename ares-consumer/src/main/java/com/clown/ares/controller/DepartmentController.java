package com.clown.ares.controller;

import com.clown.ares.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@RestController
@RequestMapping("/consumer/department")
public class DepartmentController {

    private static final String REST_URL_PREFIX = "http://ARES-PROVIDER/department";

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("unchecked")
    @GetMapping("/findAll")
    public List<Department> findAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/findAll",List.class);
    }

    @GetMapping("/findById/{departmentId}")
    public Department findById(@PathVariable("departmentId") Long departmentId){
        return restTemplate.getForObject(REST_URL_PREFIX + "/findById/" + departmentId, Department.class);
    }

    @PostMapping("/add")
    public String add(@RequestBody Department department){
        return restTemplate.postForObject(REST_URL_PREFIX + "/add", department, String.class);
    }

    @PutMapping("/update")
    public String update(@RequestBody Department department){
        try {
            restTemplate.put(REST_URL_PREFIX+"/update",department);
            return "更新成功";
        } catch (RestClientException e) {
            return "更新失败";
        }
    }

    @DeleteMapping("/delete/{departmentId}")
    public String delete(@PathVariable("departmentId") Long departmentId){
        try {
            restTemplate.delete(REST_URL_PREFIX+"/delete/"+departmentId);
            return "删除成功";
        } catch (RestClientException e) {
            return "删除失败";
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/discovery",Object.class);
    }
}
