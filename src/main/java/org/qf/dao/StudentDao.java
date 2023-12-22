package org.qf.dao;
import org.apache.ibatis.annotations.Param;
import org.qf.entity.Student;

import java.util.List;

/**
 * 数据库操作 ： 增加、删除、修改、查询等
 *
 * 接口：接口中每个方法就是一个功能业务 接口中的方法都是抽象方法 抽
 象方法没有方法体，也就没有方法实现。
 */
public interface StudentDao {

    /**
     * 增加功能
     * @param student
     * @return
     */
    public int addStu(Student student);

    /**
     * 查询所有信息
     * @return
     */
    public List<Student> showList(String name);

    /**
     * 删除功能
     * @param sid
     * @return
     */
    public int deleteStu(int sid);

    /**
     * 修改功能
     * @param student
     * @return
     */
    public int updateStu(Student student);

    /**
     * 多参数查询
     * @return 多参数查询加@Param
     */
    public Student searchStu(@Param("name") String name, @Param("age") int age);


    /**
     * 模糊查询
     * @return 传递参数名和实际参数有区别也可以加@Param
     */
    public List<Student> vagueSearchStu(@Param("stuName") String Name);

    /**
     * 分页查询
     * @return
     */
    public List<Student> PageStu();


}