package application.example.main.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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

    public String serialize() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(this);
            return URLEncoder.encode(json, "UTF-8");
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CartItem deserialize(String encodedJson) {
        try {
            String json = URLDecoder.decode(encodedJson, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, CartItem.class);
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

// Конструктор и методы доступа к полям
}