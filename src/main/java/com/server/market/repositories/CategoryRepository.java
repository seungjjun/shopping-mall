package com.server.market.repositories;

import com.server.market.models.Category;
import com.server.market.models.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, CategoryId> {
}
