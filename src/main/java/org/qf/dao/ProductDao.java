package org.qf.dao;
import org.qf.entity.Product;
import java.util.List;
public interface ProductDao {
    /**
     * 多条件查询
     * @param product
     * @return
     */
    public List<Product> showProduct(Product product);
}
