package cn.wengzi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 学生表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Integer CardId;
    private Integer ClassId;

    //学生证
    private StudentCard studentCard;
}
