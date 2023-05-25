
package application.example.main.controller;

import application.example.main.domain.CartItem;
import application.example.main.domain.Product;
import application.example.main.domain.ShoppingList;
import application.example.main.domain.User;
import application.example.main.service.ProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
            HttpServletRequest request,
            @RequestParam String userId) {

        String cookieName = "user_" + userId + "_product_" + productId;
        String productCookieValue = getCookieValue(request, cookieName);

        // Create a cart item object
        Long id = Long.valueOf(productId.replaceAll("\u00a0", ""));
        double price = Double.parseDouble(productPrice.replaceAll("\u00a0", ""));
        int quantity = Integer.parseInt(productQuantity.replaceAll("\u00a0", ""));

        CartItem item = new CartItem(id, productName, price, quantity);
        if (productCookieValue != null) {
            return productView(model);
        }

        Cookie cookie = new Cookie("user_" + userId + "_product_" + id, item.serialize());
        cookie.setPath("/");
        response.addCookie(cookie);
        return productView(model);
    }

    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @PostMapping("/changeQuantity")
    public String changeQuantity(
            @RequestParam("productId") String productId,
            @RequestParam("quantity") String productQuantity,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @AuthenticationPrincipal User user) {
        Cookie[] cookies = request.getCookies();
        Long id = Long.valueOf(productId.replaceAll("\u00a0", ""));
        int quantity = Integer.parseInt(productQuantity.replaceAll("\u00a0", ""));
        Cookie cartCookie = findCookieById(cookies, id, user.getId());

        if (cartCookie != null) {
            String cartJson = cartCookie.getValue();
            CartItem cart = CartItem.deserialize(cartJson);
            cart.setQuantity(quantity);
            Cookie cookie = new Cookie("user_" + user.getId() + "_product_" + id, cart.serialize());
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        ShoppingList cart = findProductCookies(cookies, user.getId());
        model.addAttribute("cart", cart);

        return "redirect:/bucket";


    }

    @GetMapping
    public String showCart(Model model,
                           HttpServletRequest request,
                           HttpServletResponse response,
                           @AuthenticationPrincipal User user) {

        // Retrieve the shopping cart from the cookie
        Cookie[] cookies = request.getCookies();
        ShoppingList cart = findProductCookies(cookies, user.getId());
        model.addAttribute("cart", cart);


        // Return the view name for the cart page
        return "shoppingListPlace/shoppingList";
    }


    private ShoppingList findProductCookies(@NotNull Cookie[] cookies, Long userId) {
        ShoppingList res = new ShoppingList();
        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("user_" + userId + "_product_")) {
                res.addItem(CartItem.deserialize(cookie.getValue()));
            }
        }
        return res;
    }


    private Cookie findCookieById(@NotNull Cookie[] cookies, Long id, Long userId) {
        Cookie res = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().split("_").length == 4
                    && Integer.parseInt(cookie.getName().split("_")[1]) == userId
                    && Integer.parseInt(cookie.getName().split("_")[3]) == id) {
                res = cookie;
            }
        }
        return res;
    }

    //    @Transactional
    @PostMapping("delete")
    public String positionDelete(@RequestParam String prodId,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 @AuthenticationPrincipal User user
    ) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = removePos(cookies, Long.parseLong(prodId), user.getId());
        if (cookie != null) {
            cookie.setValue("");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        // Pass the cart to the view
        // Return the redirect URL for the cart page
        return "redirect:/bucket";
    }

    private Cookie removePos(@NotNull Cookie[] cookies, Long id, Long userId) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().split("_").length == 4
                    && Integer.parseInt(cookie.getName().split("_")[1]) == userId
                    && Integer.parseInt(cookie.getName().split("_")[3]) == id) {
                return cookie;
            }
        }
        return null;
    }

}