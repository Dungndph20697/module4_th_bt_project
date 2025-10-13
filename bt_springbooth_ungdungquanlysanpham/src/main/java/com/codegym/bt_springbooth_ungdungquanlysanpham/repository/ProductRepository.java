package com.codegym.bt_springbooth_ungdungquanlysanpham.repository;

import com.codegym.bt_springbooth_ungdungquanlysanpham.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
