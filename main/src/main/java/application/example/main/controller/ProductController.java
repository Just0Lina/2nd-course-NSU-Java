package application.example.main.controller;

import application.example.main.domain.Product;
import application.example.main.domain.Role;
import application.example.main.domain.User;
import application.example.main.service.ProductService;
import application.example.main.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //    @Transactional
    @PostMapping("delete")
    public String userDeleteForm(@RequestParam String prodId, Model model) {
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
        return "productList";
    }

    @GetMapping("productCreation")
    public String showCreation() {
        System.out.println("Iam");
        return "productCreation";
    }

    //http://localhost:8080/product/productCreation
    @PostMapping("productCreation")
    public String addProduct(
            @Valid Product product,
            BindingResult bindingResult,
            Model model) {
        System.out.println("Here");

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            System.out.println(errors);
            model.mergeAttributes(errors);
            return "productCreation";
        }
        if (!productService.addProduct(product)) {
            model.addAttribute("productNameError", "Product exists!");
//            return "greeting";
            return "productCreation";
        }

        return "redirect:/productList";

    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{product}")
    public String userEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
//        model.addAttribute("roles", Role.values());

        return "productEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String productSave(
            @RequestParam String productName,
            @RequestParam double price,
            @RequestParam int productCategory,
            @RequestParam("prodId") Product prod
    ) {
        productService.saveProduct(prod, productName, price, productCategory);
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
