package cn.wengzi.ssm.service.impl;

import cn.wengzi.ssm.entity.Student;
import cn.wengzi.ssm.repository.StudentRepository;
import cn.wengzi.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created wengzi 19/8/10
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

}
