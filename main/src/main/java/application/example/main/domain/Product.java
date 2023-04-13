package application.example.main.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(name = "product_generator", sequenceName = "SEQ_PROD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "Product name cannot be empty")
    @Column(name = "product_name")
    private String productName;
    @Min(value = 0, message = "Price cannot be negative")
    @NotNull(message = "Price cannot be empty")
    private double price;

    @Min(value = 0, message = "Product category cannot be negative")
    @NotNull(message = "Product category cannot be empty")
    @Column(name = "product_category", nullable = false)
    private int productCategory;


}

