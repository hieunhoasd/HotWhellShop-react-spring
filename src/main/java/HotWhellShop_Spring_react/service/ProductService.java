package HotWhellShop_Spring_react.service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import HotWhellShop_Spring_react.domain.Product;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResCreateProductDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResGetAllProductDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResGetProductByIdDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResProductDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResUpdateProductDTO;
import HotWhellShop_Spring_react.repository.ProductRepository;
import jakarta.validation.Valid;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleCreateProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Product handleGetProductById(long id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        if (productOptional != null) {
            return productOptional.get();
        }
        return null;
    }

    public List<Product> handleGetAllProduct() {
        return this.productRepository.findAll();
    }

    public void handleDeleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public Product handleUpdateProduct(Product product) {
        Product currentProduct = this.handleGetProductById(product.getId());
        if (currentProduct != null) {
            currentProduct.setProduct_name(product.getProduct_name());
            currentProduct.setPrice(product.getPrice());
            currentProduct.setQuantity(product.getQuantity());
            currentProduct.setRarity(product.getRarity());
            currentProduct.setSeries(product.getSeries());
            currentProduct.setYear(product.getYear());

            currentProduct = this.productRepository.save(currentProduct);
        }
        return currentProduct;
    }

    public ResCreateProductDTO handleCreateProductDTO(Product product) {
        ResCreateProductDTO resProduct = new ResCreateProductDTO();

        resProduct.setId(product.getId());
        resProduct.setProduct_name(product.getProduct_name());
        resProduct.setDetail_decs(product.getDetail_decs());
        resProduct.setPrice(product.getPrice());
        resProduct.setQuantity(product.getQuantity());
        resProduct.setRarity(product.getRarity());
        resProduct.setSeries(product.getSeries());
        resProduct.setShort_decs(product.getShort_decs());
        resProduct.setYear(product.getYear());

        return resProduct;
    }

    public ResGetProductByIdDTO handleConvertGetProductByidDTO(Product fetchProduct) {
        ResGetProductByIdDTO resProduct = new ResGetProductByIdDTO();

        resProduct.setId(fetchProduct.getId());
        resProduct.setProduct_name(fetchProduct.getProduct_name());
        resProduct.setDetail_decs(fetchProduct.getDetail_decs());
        resProduct.setPrice(fetchProduct.getPrice());
        resProduct.setQuantity(fetchProduct.getQuantity());
        resProduct.setRarity(fetchProduct.getRarity());
        resProduct.setSeries(fetchProduct.getSeries());
        resProduct.setShort_decs(fetchProduct.getShort_decs());
        resProduct.setYear(fetchProduct.getYear());

        return resProduct;
    }

    public List<ResGetAllProductDTO> handleConvertGetProductDTO() {

        return this.handleGetAllProduct()
                .stream()
                .map(product -> {
                    ResGetAllProductDTO res = new ResGetAllProductDTO();
                    res.setId(product.getId());
                    res.setProduct_name(product.getProduct_name());
                    res.setDetail_decs(product.getDetail_decs());
                    res.setPrice(product.getPrice());
                    res.setQuantity(product.getQuantity());
                    res.setRarity(product.getRarity());
                    res.setSeries(product.getSeries());
                    res.setShort_decs(product.getShort_decs());
                    res.setYear(product.getYear());
                    return res;
                }).toList();

    }

    public ResUpdateProductDTO handleConvertUpdateProductDTO(Product pro) {
        ResUpdateProductDTO res = new ResUpdateProductDTO();

        res.setId(pro.getId());
        res.setDetail_decs(pro.getDetail_decs());
        res.setPrice(pro.getPrice());
        res.setQuantity(pro.getQuantity());
        res.setRarity(pro.getRarity());
        res.setSeries(pro.getSeries());
        res.setShort_decs(pro.getShort_decs());
        res.setYear(pro.getYear());

        return res;
    }

}
