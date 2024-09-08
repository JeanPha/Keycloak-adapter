package com.product_service_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.product_service_manager.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
