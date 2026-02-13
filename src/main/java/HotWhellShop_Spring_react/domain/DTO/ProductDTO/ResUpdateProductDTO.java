package HotWhellShop_Spring_react.domain.DTO.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResUpdateProductDTO {
    private String product_name;
    private long id;
    private double price;
    private String detail_decs;
    private long quantity;
    private String short_decs;
    private String series;
    private String rarity;
    private long year;
}
