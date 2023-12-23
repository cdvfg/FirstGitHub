package org.qf.test.BookTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qf.dao.BookDao;
import org.qf.entity.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ShowBookTest {
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
            BookDao bookDao = sqlSession.getMapper(BookDao.class);
            Book book=new Book();
//                book.setSname("Java");
                book.setSid(1);

            List<Book> list = bookDao.showBook(book);

            for(Book b :list){
                System.out.println(b.getSid()+"\t"+b.getSname()+"\t"+b.getPrice()+"\t"+b.getCount()+"\t"+b.getCreatetime());
            }
            System.out.println("查询成功");

        } catch (IOException e) {
            System.out.println("查询失败");
        }


    }
}