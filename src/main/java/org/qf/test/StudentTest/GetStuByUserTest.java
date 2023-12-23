package org.qf.test.StudentTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qf.dao.StudentDao;
import org.qf.entity.Student;

import java.io.IOException;
import java.io.InputStream;

public class GetStuByUserTest {
    public static void main(String[] args) {
        // 1.加载MyBatis的核心配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 2.创建会话工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);

            // 3.获取会话
            SqlSession sqlSession = factory.openSession();

            // 4.获取DAO
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            // 查询学生名字
            Student student = studentDao.getStudentByUserId(1);
            System.out.println(student);

            // 5.关闭会话
            sqlSession.close();
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("查询失败");
        }
    }
}
