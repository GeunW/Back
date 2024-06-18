package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{
    
}
