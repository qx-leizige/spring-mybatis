package cn.wengzi.ssm.repository;


import cn.wengzi.ssm.entity.Student;

import java.util.List;

/**
 * created wengzi 19/8/10
 */
public interface StudentRepository {

    List<Student> findAll();

    Student findById(Integer id);

    int addStudent(Student student);

    int updStudent(Student student);

    int delStudent(Integer id);
}
