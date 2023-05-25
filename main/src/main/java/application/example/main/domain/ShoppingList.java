
package application.example.main.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShoppingList {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public List<CartItem> getItems() {
        return items;
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

    public static ShoppingList deserialize(String encodedJson) {
        try {
            String json = URLDecoder.decode(encodedJson, "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, ShoppingList.class);
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "items=" + items +
                '}';
    }

    public void removeById(Long id) {
        int ind = -1;
        int i = 0;
        for (CartItem cartItem : items) {
            if (cartItem.getProd_id().equals(id)) {
                ind = i;
            }
            ++i;
        }
        if (ind > -1) {
            items.remove(ind);
        }
    }
}





