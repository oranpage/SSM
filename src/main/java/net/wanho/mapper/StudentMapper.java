package net.wanho.mapper;

import com.github.pagehelper.PageInfo;
import net.wanho.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dustin on 2018/11/21.
 */
public interface StudentMapper {

    Student getStudentById(@Param("id") Integer id);

    List<Student> getAllStudent(Integer PageNum);

    void deleteStudentById(@Param("id") Integer id);

    void updateStudent(@Param("id") Integer id,@Param("name") String name,@Param("age") Integer age);

    void addStudent(@Param("name") String name,@Param("age") Integer age);

    List<Student> getStudentByNameAndAge(@Param("name")String name,@Param("age") Integer age);



}
