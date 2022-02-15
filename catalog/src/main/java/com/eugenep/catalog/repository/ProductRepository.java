package com.eugenep.catalog.repository;

import com.eugenep.catalog.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findAllBySku(String sku);

}
