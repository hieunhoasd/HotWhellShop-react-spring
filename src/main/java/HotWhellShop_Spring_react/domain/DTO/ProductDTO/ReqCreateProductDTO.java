package HotWhellShop_Spring_react.domain.DTO.ProductDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqCreateProductDTO {
    @NotBlank(message = "Product name khong duo duoc de trong")
    private String product_name;

    private long id;

    private double price;
    @NotBlank(message = "Detail description khong duoc de trong")
    private String detail_decs;

    private long quantity;

    @NotBlank(message = "Short description khong duoc de trong")
    private String short_decs;

    private String series;

    private String rarity;

    private long year;
}
