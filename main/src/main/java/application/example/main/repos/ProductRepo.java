package application.example.main.repos;

import application.example.main.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);

    Product findById(long id);

    List<Product> findByProductCategory(String prod_cat);


    void deleteById(Long valueOf);

}
