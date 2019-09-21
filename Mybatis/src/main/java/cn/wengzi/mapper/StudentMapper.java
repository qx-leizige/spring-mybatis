package cn.wengzi.mapper;

import cn.wengzi.entity.Student;
import cn.wengzi.entity.StudentClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /***
     * 学生表与学生证表
     * 学生与学生证一对一
     * @param StuId 学生id
     * @return
     */
    Student QueryStudentJoinStudentCardOneToOneByStuId(@Param("id") Integer StuId);

    /**
     * 学生表与班级表
     * 一个班级对应一个学生
     *
     * @param ClassId 班级Id
     * @return
     */
    List<StudentClass> QueryStudentJoinStudentClassOneToManyByClassId(@Param("id") Integer ClassId);
}
