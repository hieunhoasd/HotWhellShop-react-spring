package HotWhellShop_Spring_react.controller;

import org.springframework.web.bind.annotation.RestController;

import HotWhellShop_Spring_react.domain.Product;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResCreateProductDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResGetAllProductDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResGetProductByIdDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResProductDTO;
import HotWhellShop_Spring_react.domain.DTO.ProductDTO.ResUpdateProductDTO;
import HotWhellShop_Spring_react.service.ProductService;
import jakarta.validation.Valid;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // create product
    @PostMapping("/products")
    public ResponseEntity<ResCreateProductDTO> createProduct(@Valid @RequestBody Product product) {
        Product pr = this.productService.handleCreateProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.handleCreateProductDTO(pr));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ResGetProductByIdDTO> getProductById(@PathVariable("id") long id) {
        Product fetchProduct = this.productService.handleGetProductById(id);
        return ResponseEntity.ok(this.productService.handleConvertGetProductByidDTO(fetchProduct));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ResGetAllProductDTO>> getAllProduct() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.handleConvertGetProductDTO());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductByid(@PathVariable("id") long id) {
        this.productService.handleDeleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Product");
    }

    @PutMapping("/products")
    public ResponseEntity<ResUpdateProductDTO> updateProduct(@RequestBody Product product) {
        Product pro = this.productService.handleUpdateProduct(product);
        return ResponseEntity.ok(this.productService.handleConvertUpdateProductDTO(pro));
    }

}
