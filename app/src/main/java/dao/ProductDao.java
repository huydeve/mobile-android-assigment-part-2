package dao;

import android.arch.persistence.room.*;
import com.example.shop.entity.Product;

import java.util.List;
@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Query("DELETE FROM product WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM product")
    List<Product> getAllProducts();
}
