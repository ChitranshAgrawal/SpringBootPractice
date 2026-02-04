package com.guchi.simpleWebApp.service;

import com.guchi.simpleWebApp.model.Product;
import com.guchi.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "iPhone", 100000),
//            new Product(102, "Samsung", 70000),
//            new Product(103, "Oppo", 15000)));

    public List<Product> getProducts() {
//        return products;
        return repo.findAll();
    }

    public Product getProductById(int productId) {
//        return products.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(new Product(0, "No Item", 0));
        return repo.findById(productId).orElse(new Product());
    }

//    public void addProduct(Product product) {
////        products.add(product);
//        repo.save(product);
//    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

//    public Product updateProduct(int productId, Product product, MultipartFile imageFile) throws IOException {
//
////        int idx = 0;
////
////        for ( int i = 0 ; i < products.size() ; i++ )
////            if ( products.get(i).getProductId() == product.getProductId() )
////                idx = i;
////
////        products.set(idx, product);
//
//        product.setImageData(imageFile.getBytes());
//        product.setImageName((imageFile.getOriginalFilename()));
//        product.setImageType(imageFile.getContentType());
//        return repo.save(product);
//    }

    public Product updateProduct(int productId, Product updatedProduct, MultipartFile imageFile) throws IOException {

        Product existingProduct = repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // update fields
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductDesc(updatedProduct.getProductDesc());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setAvailable(updatedProduct.getAvailable());
        existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
        existingProduct.setReleaseDate(updatedProduct.getReleaseDate());

        // update image ONLY if new image is sent
        if (imageFile != null && !imageFile.isEmpty()) {
            existingProduct.setImageData(imageFile.getBytes());
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());
        }

        return repo.save(existingProduct);
    }

    public void deleteProduct(int productId) {

//        int idx = 0;
//
//        for ( int i = 0 ; i < products.size() ; i++ )
//            if ( products.get(i).getProductId() == productId )
//                idx = i;
//
//        products.remove(idx);

        repo.deleteById(productId);
    }
}



