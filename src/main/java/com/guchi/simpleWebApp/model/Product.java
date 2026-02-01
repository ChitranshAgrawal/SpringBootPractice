package com.guchi.simpleWebApp.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
//@Entity
@NoArgsConstructor
@Document // Mongodb document (it tells that it is the database)
public class Product {

    @Id // primary key
    private int productId;
    private String productName;
    private int price;

}



