package cn.wengzi.mapper;

import cn.wengzi.entity.Student;
import cn.wengzi.entity.StudentClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /***
     * 学生表与学生证表
     * 一个学生对应一个学生证
     * @param StuId 学生id
     * @return
     */
    Student QueryStudentJoinStudentCardOneToOneByStuId(@Param("id") Integer StuId);

    /**
     * 学生表与班级表
     * 一个班级对应多个学生
     * 一个学生对应一个学生证
     *
     * @param ClassId 班级Id
     * @return
     */
    List<StudentClass> QueryStudentJoinStudentClassOneToManyByClassId(@Param("id") Integer ClassId);

    /**
     * 调用存储过程 查询全部学生
     *
     * @return
     */
    List<Student> queryStudentAll();

    /**
     * 调用存储过程 根据id查询学生信息
     *
     * @param id Student id
     * @return
     */
    Student queryStudentById(Integer id);
}
