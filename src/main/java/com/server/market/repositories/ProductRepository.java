package com.server.market.repositories;

import com.server.market.models.category.CategoryId;
import com.server.market.models.product.Product;
import com.server.market.models.product.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
    List<Product> findAllByCategoryId(CategoryId categoryId);
}
