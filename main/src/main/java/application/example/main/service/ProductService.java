package application.example.main.service;

import application.example.main.domain.Product;
import application.example.main.repos.ProductRepo;
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
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private FileService<Product> fileService;


    //    private final UserRepo userRepo;
//
//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }


    public List<Product> loadProductsByProdName(String username) {
        List<Product> products = productRepo.findByProductName(username);
        if (products.isEmpty()) {
            return null;
        }
        return products;
    }

    public boolean addProduct(Product prod) {
        if (prod.getId() != null) {
            Optional<Product> product = productRepo.findById(prod.getId());
            if (product.isPresent()) return false;
        }
        productRepo.save(prod);
        return true;
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public void deleteById(long id) {
        productRepo.deleteById(id);
    }

    public void saveFile(Product prod, MultipartFile file) throws IOException {
        String f = fileService.saveFile(prod, file);
        prod.setFilename(f);
        productRepo.save(prod);
    }

    public void saveProduct(Product prod, String prodName, double price, int prod_cat, MultipartFile file) throws IOException {
        prod.setProductName(prodName);
        prod.setPrice(price);
        prod.setProductCategory(prod_cat);
        saveFile(prod, file); //save
    }

    public void updateProduct(Product prod, String newName, double price, int prod_cat) {
        if (!StringUtils.isEmpty(newName)) {
            prod.setProductName(newName);
        }
        if (price >= 0) {
            prod.setPrice(price);
        }
        if (prod_cat >= 0) {
            prod.setProductCategory(prod_cat);
        }
        productRepo.save(prod);
    }


}
