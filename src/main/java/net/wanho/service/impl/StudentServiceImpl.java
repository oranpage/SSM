package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.StudentMapper;
import net.wanho.model.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dustin on 2018/11/26.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentMapper studentMapper;



    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public PageInfo<Student> getAllStudent(Integer pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Student> students = studentMapper.getAllStudent(pageNum);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }

    @Override
    public void addStudent(String name, Integer age) {
        studentMapper.addStudent(name,age);
    }

    @Override
    public void uppdateStudent(Integer id, String name, Integer age) {
        studentMapper.updateStudent(id,name,age);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentMapper.deleteStudentById(id);
    }

    @Override
    public List<Student> getStudentByNameAndAge( String name,Integer age) {
        return studentMapper.getStudentByNameAndAge(name,age);
    }


}
