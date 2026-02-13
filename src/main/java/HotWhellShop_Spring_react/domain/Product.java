package HotWhellShop_Spring_react.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    private String product_name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    private String detail_decs;
    private long quantity;
    private String short_decs;
    private String series;
    private String rarity;
    private long year;
}
