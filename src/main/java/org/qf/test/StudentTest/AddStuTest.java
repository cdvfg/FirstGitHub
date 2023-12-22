package org.qf.test.StudentTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qf.dao.StudentDao;
import org.qf.entity.Student;
import java.io.IOException;
import java.io.InputStream;
public class AddStuTest {
    public static void main(String[] args) {
//1.加载mybatis的核心配置文件
        try {
            InputStream inputStream =
                    Resources.getResourceAsStream("mybatis-config.xml");
//2.创建会话工厂
            SqlSessionFactoryBuilder builder=new
                    SqlSessionFactoryBuilder();
            SqlSessionFactory
                    factory=builder.build(inputStream);
//3.获取会话
            SqlSession sqlSession=factory.openSession();
//4.获取dao
            StudentDao studentDao =
                    sqlSession.getMapper(StudentDao.class);
            Student student=new Student();
            student.setStuNum("002");
            student.setStuName("李四");
            student.setStuGender("男");
            student.setStuAge(22);
            int i = studentDao.addStu(student);
//增加、删除、修改提交事务
            sqlSession.commit();
            if(i>0){
                System.out.println("增加成功");
            }else{
                System.out.println("增加失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}