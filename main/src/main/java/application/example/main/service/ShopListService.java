
package application.example.main.service;

import application.example.main.domain.Product;
import application.example.main.domain.ShoppingList;
import application.example.main.domain.User;
import application.example.main.repos.ProductRepo;
import application.example.main.repos.ShopListRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShopListService {
    @Autowired
    private ShopListRepo shopListRepo;

    //    private final UserRepo userRepo;
//
//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }


    public List<ShoppingList> loadProductsByUser(User user) {
        List<ShoppingList> list = shopListRepo.findByUser(user);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public boolean addPosition(ShoppingList prod) {
        if (prod.getId() != null) {
            Optional<ShoppingList> product = shopListRepo.findById(prod.getId());
            if (product.isPresent()) return false;
        }
        shopListRepo.save(prod);
        return true;
    }

    public List<ShoppingList> findAll() {
        return shopListRepo.findAll();
    }

    public void deleteById(long id) {
        shopListRepo.deleteById(id);
    }


    public void savePosition(ShoppingList position, User user, int quantity, Product product) throws IOException {
        position.setQuantity(quantity);
        position.setProduct(product);
        position.setUser(user);
        shopListRepo.save(position);
    }

    public void updateProduct(ShoppingList prod, int quantity) {
        if (quantity < 0) {
            shopListRepo.deleteById(prod.getId());
        } else {
            prod.setQuantity(quantity);
        }
        shopListRepo.save(prod);
    }


}
