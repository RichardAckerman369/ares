package com.clown.ares.mapper;

import com.clown.ares.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAll();

    @Select("SELECT * FROM department WHERE departmentId = #{departmentId}")
    Department findById(Long departmentId);

    @Options(useGeneratedKeys = true,keyColumn = "departmentId",keyProperty = "departmentId")
    @Insert("INSERT INTO department(departmentName,db_source) VALUES(#{departmentName},#{db_source})")
    void add(Department department);

    @Update("UPDATE department SET departmentName = #{departmentName},db_source = #{db_source} WHERE departmentId = #{departmentId}")
    void update(Department department);

    @Delete("DELETE FROM department WHERE departmentId= #{departmentId}")
    void delete(Long departmentId);
}
