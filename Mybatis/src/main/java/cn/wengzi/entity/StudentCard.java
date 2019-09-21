package cn.wengzi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 学生证类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCard {
    private Integer cardId;
    private String cardInfo;
}
