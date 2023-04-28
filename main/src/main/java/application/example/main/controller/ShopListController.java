
package application.example.main.controller;

import application.example.main.domain.CartItem;
import application.example.main.domain.Product;
import application.example.main.domain.ShoppingList;
import application.example.main.service.ProductService;
import application.example.main.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/bucket")
public class ShopListController {
    //    @Autowired
//    private ShopListService shopListService;
    @Autowired
    private ProductService productService;


    //    @Transactional
    @PostMapping("delete")
    public String userDeleteForm(@RequestParam String prodId, Model model) {
        System.out.println("Ber");
        Long id = Long.valueOf(prodId.replaceAll("\u00a0", ""));
        // shopListService.deleteById(id);

        return "redirect:/bucket";
    }

    @GetMapping("/productView")
    public String productView(Map<String, Object> model) {
        Iterable<Product> products = productService.findAll();
        model.put("products", products);
        return "productPlace/productView";
    }


    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam("productName") String productName,
                            @RequestParam("productPrice") double productPrice,
                            Model model) {
        System.out.println("HERE");
        // Use the information from the button to add the product to the cart
        ShoppingList cart = (ShoppingList) model.getAttribute("cart");

        cart.addItem(new CartItem(productId, productPrice, 1));

        return "redirect:/bucket";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String shopList(Model model) {
        System.out.println("Here");
        //   model.addAttribute("list", shopListService.findAll());
        return "/shoppingListPlace/shoppingList";
    }
//
//    @GetMapping("productCreation")
//    public String showCreation() {
//        System.out.println("Iam");
//        return "/shoppingListPlace/productCreation";
//    }
//
//    @GetMapping("shopping-cart")
//    public String showBuscket() {
//        System.out.println("Iam");
//        return "/shoppingListPlace/shoppingCart";
//    }
//
//    //http://localhost:8080/product/productCreation
//    @PostMapping("productCreation")
//    public String addProduct(
//            @Valid Product product,
//            BindingResult bindingResult,
//            Model model,
//            @RequestParam("file") MultipartFile file) throws IOException {
//        System.out.println("Here");
//
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
//            System.out.println(errors);
//            model.mergeAttributes(errors);
////            return "main";
//            return "/shoppingListPlace/productCreation";
//        }
//        if (!shopListService.addProduct(product)) {
//            model.addAttribute("productNameError", "Product exists!");
////            return "greeting";
//            return "/shoppingListPlace/productCreation";
//        }
//        shopListService.saveFile(product, file);
//
//        return "redirect:/product";
//
//    }
//
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping("{product}")
//    public String userEditForm(@PathVariable Product product, Model model) {
//        model.addAttribute("product", product);
////        model.addAttribute("roles", Role.values());
//
//        return "shoppingListPlace/productEdit";
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping
//    public String productSave(
//            @RequestParam String productName,
//            @RequestParam double price,
//            @RequestParam int productCategory,
//            @RequestParam("prodId") Product prod,
//            @RequestParam("file") MultipartFile file) throws IOException {
//        shopListService.saveProduct(prod, productName, price, productCategory, file);
//
//        return "redirect:/product";
//    }

//    @Transactional
//    @PostMapping("{product}/delete")
//    public String userDeleteForm(@RequestParam String prodId, Model model) {
//        Long id = Long.valueOf(prodId.replaceAll("\u00a0", ""));
//        shopListService.deleteById(id);
//
//        return "redirect:/product";
//    }


}
