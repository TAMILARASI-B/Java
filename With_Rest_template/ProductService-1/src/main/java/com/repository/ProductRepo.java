package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

}
