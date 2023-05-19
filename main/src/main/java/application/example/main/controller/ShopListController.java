
package application.example.main.controller;

import application.example.main.domain.CartItem;
import application.example.main.domain.Product;
import application.example.main.domain.ShoppingList;
import application.example.main.service.ProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bucket")

public class ShopListController {
    //    //    @Autowired
//    private ShopListService shopListService;
    @Autowired
    private ProductService productService;

    @GetMapping("/productView")
    public String productView(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "productPlace/productView";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(
            @RequestParam("productId") String productId,
            @RequestParam("productName") String productName,
            @RequestParam("productPrice") String productPrice,
            @RequestParam("productQuantity") String productQuantity,
            Model model,
            HttpServletResponse response,
            @CookieValue(value = "shoppingList3", required = false) String cartCookieValue) {

        // Create a cart item object and add it to the cart
        Long id = Long.valueOf(productId.replaceAll("\u00a0", ""));
        double price = Double.valueOf(productPrice.replaceAll("\u00a0", ""));
        int quantity = Integer.valueOf(productQuantity.replaceAll("\u00a0", ""));

        CartItem item = new CartItem(id, productName, price, quantity);
        ShoppingList cart;

        if (cartCookieValue != null) {
            // If the cookie exists, retrieve the cart from the cookie
            cart = ShoppingList.deserialize(cartCookieValue);
        } else {
            // If the cookie is absent, create a new cart
            cart = new ShoppingList();
        }

        cart.addItem(item);

        // Save the cart in the cookie
        Cookie cookie = new Cookie("shoppingList3", cart.serialize());
        cookie.setPath("/"); // Set the path to the root directory so that the cookie is accessible on all pages
        response.addCookie(cookie);
        System.out.println(cookie.getName());

        // Set the cart attribute in the model
        model.addAttribute("cart", cart);

        // Return the view name
        return productView(model);
    }

    @GetMapping
    public String showCart(Model model,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        // Retrieve the shopping cart from the cookie
        Cookie[] cookies = request.getCookies();
        Cookie cartCookie = findCartCookie(cookies);

        if (cartCookie != null) {
            String cartJson = cartCookie.getValue();
            ShoppingList cart = ShoppingList.deserialize(cartJson);
            // Pass the cart to the view
            model.addAttribute("cart", cart);
        }

        // Return the view name for the cart page
        return "shoppingListPlace/shoppingList";
    }


    private Cookie findCartCookie(Cookie[] cookies) {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("shoppingList3")) {
                    return cookie;
                }
            }
        }
        return null;
    }

    //    @Transactional

    @PostMapping("delete")
    public String positionDelete(@RequestParam String prodId,
                                 Model model,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie cartCookie = removePos(cookies, Long.parseLong(prodId));
        response.addCookie(cartCookie);

        // Pass the cart to the view
        // Return the redirect URL for the cart page
        return "redirect:/bucket";
    }

    private Cookie removePos(Cookie[] cookies, Long id) {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("shoppingList3")) {
                    String cartJson = cookie.getValue();
                    ShoppingList cart = ShoppingList.deserialize(cartJson);

                    cart.removeById(id);
                    cookie.setValue(cart.serialize());
                    return cookie;
                }
            }
        }
        return null;

    }
}