package com.hfut.mapper;

import com.hfut.pojo.Student;
import com.hfut.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select s.id ,s.name,age,tid,t.id `teacher.id`, t.name 'teacher.name'" +
            "from student s left join teacher t on s.id=t.id")
   List<Student>selAll();

    @Select("select * from student where tid=#{0}")
    List<Student>selByTid(int tid);
}
