package HotWhellShop_Spring_react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HotWhellShop_Spring_react.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
