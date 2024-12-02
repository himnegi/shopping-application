package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.dto.InventoryResponse;
import com.microservices.inventoryservice.repository.InventoryRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Wait started {}", LocalDateTime.now());
        Thread.sleep(10000);
        log.info("Wait Ended {}", LocalDateTime.now());
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream().map(inventory ->
                    InventoryResponse.builder()
                            .isInStock(inventory.getQuantity() > 0)
                            .skuCode(inventory.getSkuCode()).build()
                ).toList();
    }
}
