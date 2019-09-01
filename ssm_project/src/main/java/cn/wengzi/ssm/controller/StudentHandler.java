package cn.wengzi.ssm.controller;

import cn.wengzi.ssm.entity.Student;
import cn.wengzi.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created wengzi 19/8/10
 */
@RestController
@RequestMapping(value = "/student")
public class StudentHandler {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping(value = "/findAll")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @ResponseBody
    @GetMapping(value = "findById/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }

}
