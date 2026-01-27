package com.guchi.simpleWebApp.service;

import com.guchi.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "iPhone", 100000),
            new Product(102, "Samsung", 70000),
            new Product(103, "Oppo", 15000)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(new Product(0, "No Item", 0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {

        int idx = 0;

        for ( int i = 0 ; i < products.size() ; i++ )
            if ( products.get(i).getProductId() == product.getProductId() )
                idx = i;

        products.set(idx, product);
    }

    public void deleteProduct(int productId) {

        int idx = 0;

        for ( int i = 0 ; i < products.size() ; i++ )
            if ( products.get(i).getProductId() == productId )
                idx = i;

        products.remove(idx);
    }
}




