package com.product_service_manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.product_service_manager.entity.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}
