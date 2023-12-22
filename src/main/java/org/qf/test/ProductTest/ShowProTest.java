package org.qf.test.ProductTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qf.dao.ProductDao;
import org.qf.dao.StudentDao;
import org.qf.entity.Product;
import org.qf.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ShowProTest {
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
            ProductDao productDao = sqlSession.getMapper(ProductDao.class);
            Product product=new Product();
            product.setProduct_name("Product1");

            List<Product> list = productDao.showProduct(product);

            for(Product p :list){
                System.out.println(p.getProduct_id()+"\t"+p.getProduct_name()+"\t"+p.getPrice()+"\t"+p.getCategory());
            }
            System.out.println("查询成功");

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("查询失败");
        }


    }
}