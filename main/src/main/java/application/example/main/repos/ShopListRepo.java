package application.example.main.repos;

import application.example.main.domain.Product;
import application.example.main.domain.ShoppingList;
import application.example.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopListRepo extends JpaRepository<ShoppingList, Long> {
    List<ShoppingList> findByUser(User user);

    void deleteById(Long valueOf);

}