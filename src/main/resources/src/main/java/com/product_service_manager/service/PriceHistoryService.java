package com.product_service_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service_manager.entity.PriceHistory;
import com.product_service_manager.repository.PriceHistoryRepository;

@Service
public class PriceHistoryService {

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    public List<PriceHistory> findAll() {
        return priceHistoryRepository.findAll();
    }

    public Optional<PriceHistory> findById(Long id) {
        return priceHistoryRepository.findById(id);
    }

    public PriceHistory save(PriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }

    public void deleteById(Long id) {
        priceHistoryRepository.deleteById(id);
    }
}

