package application.example.main.domain;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Long prod_id;

    private String productName;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "CartItem{" +
                "prod_id=" + prod_id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

// Конструктор и методы доступа к полям
}