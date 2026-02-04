package com.guchi.simpleWebApp.repository;

import com.guchi.simpleWebApp.model.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository
//public interface ProductRepo extends JpaRepository<Product, Integer> {
//
//}

//@Repository
//public interface ProductRepo extends MongoRepository<Product, Integer> // <className (in model), data type of primary key>
//{}

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//    Product findByUsername(String username);
}

