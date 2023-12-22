package org.qf.test.StudentTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qf.dao.StudentDao;

import java.io.IOException;
import java.io.InputStream;

public class DeleteStuTest {

    public static void main(String[] args) {

        //1.加载mybatis的核心配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //2.创建会话工厂
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();

            SqlSessionFactory factory=builder.build(inputStream);

            //3.获取会话
            SqlSession sqlSession=factory.openSession();

            //4.获取dao
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            int i = studentDao.deleteStu(3);
        //增加、删除、修改提交事务
            sqlSession.commit();
            if(i>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
