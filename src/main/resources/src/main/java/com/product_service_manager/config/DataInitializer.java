package com.product_service_manager.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product_service_manager.entity.Category;
import com.product_service_manager.repository.CategoryRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if there are existing categories
        if (categoryRepository.count() == 0) {
            // Create default categories
            List<Category> defaultCategories = Arrays.asList(
                    new Category(null, "Category A", "Category A"),
                    new Category(null, "Category B", "Category B"),
                    new Category(null, "Category C", "Category C")
            );
            categoryRepository.saveAll(defaultCategories);
            System.out.println("Default categories inserted.");
        } else {
            System.out.println("Categories already present in the database.");
        }
    }
}

