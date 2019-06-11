package com.hfut.test;

import com.hfut.mapper.StudentMapper;
import com.hfut.mapper.TeacherMapper;
import com.hfut.pojo.Student;
import com.hfut.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();

        //使用注解进行查询
        TeacherMapper tm=session.getMapper(TeacherMapper.class);
        List<Teacher> list=tm.sellAll();
        System.out.println(list);

        //使用注解进行插入操作
        Teacher teacher=new Teacher();
        teacher.setName("测试");
        int index=tm.ineTeacher(teacher);

        //使用注解进行修改
        teacher=new Teacher();
        teacher.setId(3);
        teacher.setName("王五");
        tm.updTeacher(teacher);

        //使用注解进行删除
        tm.delById(5);


        session.commit();

        StudentMapper sm=session.getMapper(StudentMapper.class);
        List<Student>stulist=sm.selAll();
        for(Student tem:stulist){
            System.out.println(tem);
        }

        List<Teacher>list2=tm.selTeacher();
        System.out.println(list2);

        session.close();
        System.out.println("程序执行结束");

    }
}
