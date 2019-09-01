package cn.wengzi.ssm.service;

import cn.wengzi.ssm.entity.Student;

import java.util.List;

/**
 * created wengzi 19/8/10
 */
public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);
}
