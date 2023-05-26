package application.example.main.controller;

import application.example.main.domain.Product;
import application.example.main.service.FileService;
import application.example.main.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final String REDIRECT_PRODUCT = "redirect:/product";
    private static final String PRODUCT_CREATION = "/productPlace/productCreation";

    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;


    //    @Transactional
    @PostMapping("delete")
    public String productDeleteForm(@RequestParam String prodId, Model model) {
        Long id = Long.valueOf(prodId.replaceAll("\u00a0", ""));
        productService.deleteById(id);

        return REDIRECT_PRODUCT;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/productPlace/productList";
    }

    @GetMapping("productCreation")
    public String showCreation() {
        return PRODUCT_CREATION;
    }

    @GetMapping("shopping-cart")
    public String showBucket() {
        return "/productPlace/shoppingCart";
    }

    //http://localhost:8080/product/productCreation
    @PostMapping("productCreation")
    public String addProduct(
            @Valid Product product,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return PRODUCT_CREATION;
        }
        if (!productService.addProduct(product)) {
            model.addAttribute("productNameError", "Product exists!");
            return PRODUCT_CREATION;
        }
        productService.saveFile(product, file);

        return REDIRECT_PRODUCT;

    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{product}")
    public String productEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);

        return "productPlace/productEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String productSave(
            @RequestParam String productName,
            @RequestParam String price,
            @RequestParam int productCategory,
            @RequestParam("prodId") Product prod,
            @RequestParam("file") MultipartFile file) throws IOException {
        productService.saveProduct(prod, productName, Double.parseDouble(price.replaceAll("\u00a0", "")), productCategory, file);

        return REDIRECT_PRODUCT;
    }


}
