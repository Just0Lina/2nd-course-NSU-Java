package application.example.main.servlet;

import application.example.main.domain.CartItem;
import application.example.main.domain.Product;
import application.example.main.domain.ShoppingList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/bucket")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получить информацию о товаре, который нужно добавить
        Long id = Long.parseLong(request.getParameter("prod_id"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Создать объект элемента корзины и добавить его в корзину
        CartItem item = new CartItem(id, price, quantity);
        ShoppingList cart = getCart(request);
        cart.addItem(item);
        String value = String.valueOf(quantity) + ',' + price;
        // Создать cookie с информацией о товаре
        Cookie cookie = new Cookie("product_" + id, value);
        response.addCookie(cookie);

        // Перенаправить пользователя на страницу корзины
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получить информацию о товаре, который нужно удалить
        int index = Integer.parseInt(request.getParameter("index"));

        // Удалить элемент из корзины
        ShoppingList cart = getCart(request);
        cart.removeItem(index);

        // Удалить cookie с информацией о товаре

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("product_")) {
                String productId = cookie.getName().substring(8);
                String cookieValue = cookie.getValue();
                String[] values = cookieValue.split(",");
                int quantity = Integer.parseInt(values[0]);
                double price = Integer.parseInt(values[1]);
                // обработка данных о товаре

            }
        }

        // Перенаправить пользователя на страницу корзины
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }

    private ShoppingList getCart(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        ShoppingList cart = (ShoppingList) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingList();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}