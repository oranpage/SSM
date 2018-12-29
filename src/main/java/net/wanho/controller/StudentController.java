package net.wanho.controller;


import com.github.pagehelper.PageInfo;
import net.wanho.model.Student;

import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by dustin on 2018/11/26.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentServiceI studentService;

//    @RequestMapping
//    @ResponseBody
//    public List<Student> getAllStudent(){
//        return studentSe
// rvice.getAllStudent();
//    }
//
//    @RequestMapping("id/{id}")
//    @ResponseBody
//    public Student getStudentById(@PathVariable Integer id){
//        return  studentService.getStudentById(id);
//    }

    //查询所有学生信息
    @RequestMapping
    public ModelAndView getAllStudent(@RequestParam(defaultValue = "1") Integer pageNum, Map map) {
        PageInfo<Student> pageInfo = studentService.getAllStudent(pageNum);
        ModelAndView mv = new ModelAndView();
        mv.addObject("students", pageInfo.getList());
        mv.addObject("totalPages", pageInfo.getPages());
        mv.addObject("currentPage", pageNum);
        mv.setViewName("select");
       return mv;
    }

    //删除学生信息
    //删除学生信息
    @RequestMapping("delete")
    public String deleteStudent(Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";

    }

    //增加学生
    @RequestMapping("toAdd")
    public String toAddStudent() {
        return "add";
    }

    @RequestMapping("add")
    public String addStudent(String name, Integer age) {
        studentService.addStudent(name, age);
        return "redirect:/student";
    }

    //根据id查询學生信息
    @RequestMapping("id")
    public String getStudentById(Map map, Integer id) {
        Student student = studentService.getStudentById(id);
        map.put("student", student);
        return "update";
    }

    //修改学生信息
    @RequestMapping("update")
    public String updateStudent(Integer id, String name, Integer age) {
        studentService.uppdateStudent(id, name, age);
        return "redirect:/student";

    }

    //根据条件查询
    @RequestMapping("search")
    public ModelAndView getStudentByNameAndAge(String name, Integer age) {
        List<Student> students = studentService.getStudentByNameAndAge(name, age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("students", students);
        mv.setViewName("select");
        return mv;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}


