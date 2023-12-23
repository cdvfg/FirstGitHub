package org.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //相当于set和get方法
@AllArgsConstructor //有参构造函数
@NoArgsConstructor //无参构造函数
public class Book {
    private int sid;
    private String sname;
    private int price;
    private int count;
    private String createtime;

}
