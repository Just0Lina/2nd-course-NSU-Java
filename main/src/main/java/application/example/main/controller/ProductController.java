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
    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;


    //    @Transactional
    @PostMapping("delete")
    public String productDeleteForm(@RequestParam String prodId, Model model) {
        System.out.println("Ber");
        Long id = Long.valueOf(prodId.replaceAll("\u00a0", ""));
        productService.deleteById(id);

        return "redirect:/product";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String productList(Model model) {
        System.out.println("Here");
        model.addAttribute("products", productService.findAll());
        return "/productPlace/productList";
    }

    @GetMapping("productCreation")
    public String showCreation() {
        System.out.println("Iam");
        return "/productPlace/productCreation";
    }

    @GetMapping("shopping-cart")
    public String showBucket() {
        System.out.println("Iam");
        return "/productPlace/shoppingCart";
    }

    //http://localhost:8080/product/productCreation
    @PostMapping("productCreation")
    public String addProduct(
            @Valid Product product,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Here");

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            System.out.println(errors);
            model.mergeAttributes(errors);
//            return "main";
            return "/productPlace/productCreation";
        }
        if (!productService.addProduct(product)) {
            model.addAttribute("productNameError", "Product exists!");
//            return "greeting";
            return "/productPlace/productCreation";
        }
        productService.saveFile(product, file);

        return "redirect:/product";

    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{product}")
    public String productEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
//        model.addAttribute("roles", Role.values());

        return "productPlace/productEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String productSave(
            @RequestParam String productName,
            @RequestParam double price,
            @RequestParam int productCategory,
            @RequestParam("prodId") Product prod,
            @RequestParam("file") MultipartFile file) throws IOException {
        productService.saveProduct(prod, productName, price, productCategory, file);

        return "redirect:/product";
    }

//    @Transactional
//    @PostMapping("{product}/delete")
//    public String userDeleteForm(@RequestParam String prodId, Model model) {
//        Long id = Long.valueOf(prodId.replaceAll("\u00a0", ""));
//        productService.deleteById(id);
//
//        return "redirect:/product";
//    }


}
