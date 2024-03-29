package com.hfut.mapper;

import com.hfut.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> sellAll();

    @Insert("insert into teacher values(default,#{name})")
    int ineTeacher(Teacher teacher);

    @Update("update teacher set name=#{name} where id=#{id}")
    int updTeacher(Teacher teacher);

    @Delete("delete from teacher where id=#{0}")
    int delById(int id);

    @Results(value = {@Result(id=true,property = "id",column = "id"),
    @Result(property = "name",column = "name"),
    @Result(property = "list",column = "id",many =@Many(select = "com.hfut.mapper.StudentMapper.selByTid") )
    })
    @Select("select * from teacher")
    List<Teacher> selTeacher();
}
