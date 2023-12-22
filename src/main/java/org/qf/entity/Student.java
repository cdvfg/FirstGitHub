package org.qf.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 对应的是stu_students表
 *
 * 封装：步骤：1.属性私有化(private) 2.生成get和set方法
 *
 * //插件lombok：可以使用注解来生成get和set方法
 *
 * // 1.导入依赖： lombok
 */
@Data //相当于set和get方法
@AllArgsConstructor //有参构造函数
@NoArgsConstructor //无参构造函数
public class Student {
    private int sid;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
}
