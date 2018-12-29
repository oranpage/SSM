package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.model.Student;

import java.util.List;

/**
 * Created by dustin on 2018/11/26.
 */
public interface StudentServiceI {
    Student getStudentById(Integer id);

    PageInfo<Student> getAllStudent(Integer PageNum);

     //增加学生
    void addStudent(String name,Integer age);
    //修改学生
    void uppdateStudent(Integer id,String name,Integer age);
    //根据id删除学生
    void deleteStudentById(Integer id);

    //根据名字和年龄查询学生信息
    List<Student> getStudentByNameAndAge( String name, Integer age);



}
