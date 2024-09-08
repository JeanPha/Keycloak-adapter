package com.product_service_manager.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service_manager.entity.PriceHistory;
import com.product_service_manager.entity.Product;
import com.product_service_manager.entity.StockMovement;
import com.product_service_manager.repository.PriceHistoryRepository;
import com.product_service_manager.repository.ProductRepository;
import com.product_service_manager.repository.StockMovementRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Autowired
    private StockMovementRepository stockMovementRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    
    public Optional<Product> updatePrice(Long id, Double newPrice) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            // Guardar el historial de precios
            PriceHistory priceHistory = new PriceHistory();
            priceHistory.setPrice(newPrice);
            priceHistory.setDate(LocalDateTime.now());
            priceHistory.setProduct(product);
            priceHistoryRepository.save(priceHistory);

            product.setPrice(newPrice);
            productRepository.save(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public Optional<Product> updateStock(Long id, Integer newStock) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            // Guardar el movimiento de stock
            StockMovement stockMovement = new StockMovement();
            stockMovement.setQuantity(newStock - product.getStock());
            stockMovement.setDate(LocalDateTime.now());
            stockMovement.setProduct(product);
            stockMovementRepository.save(stockMovement);

            product.setStock(newStock);
            productRepository.save(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
