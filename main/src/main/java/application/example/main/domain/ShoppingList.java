
package application.example.main.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
@Table(name = "shoppingList")
@NoArgsConstructor
public class ShoppingList {
    @Id
    @SequenceGenerator(name = "shopList_generator", sequenceName = "SEQ_SHLIST", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopList_generator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr.user_id")
    private User user;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products.id")
    private Product product;


}

