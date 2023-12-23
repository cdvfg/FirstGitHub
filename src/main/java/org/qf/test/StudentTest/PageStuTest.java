package org.qf.test.StudentTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qf.dao.StudentDao;
import org.qf.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageStuTest {
    public static void main(String[] args) {

        // 1.加载 MyBatis 的核心配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 2.创建会话工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);

            // 3.获取会话
            SqlSession sqlSession = factory.openSession();

            // 4.获取 DAO
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            // 5.使用 PageHelper 开启分页，参数为当前页数和每页显示的条数
            PageHelper.startPage(2, 3);

            // 6.调用查询方法，注意：在调用查询方法之前要执行 PageHelper.startPage 方法
            List<Student> list = studentDao.PageStu();

            // 7.使用 PageInfo 封装查询结果，方便获取分页信息
            PageInfo<Student> pageInfo = new PageInfo<>(list);

            System.out.println("------------分页------------");
            System.out.println("当前页：" + pageInfo.getPageNum());
            System.out.println("一页显示的条数：" + pageInfo.getPageSize());
            System.out.println("总条数：" + pageInfo.getTotal());
            System.out.println("总页数：" + pageInfo.getPages());
            System.out.println("------------数据------------");
            System.out.println("查询成功");

        } catch (IOException e) {
            System.out.println("查询失败");
        }
    }
}
