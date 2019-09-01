package cn.wengzi.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通过Ioc注入复杂类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Collections implements Serializable {
    private List<String> lists;
    private String[] arrays;
    private Map<String, String> maps;
}
