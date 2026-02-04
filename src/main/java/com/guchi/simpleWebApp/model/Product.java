package com.guchi.simpleWebApp.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//import org.springframework.data.mongodb.core.mapping.Document;


//@Data
//@AllArgsConstructor
////@Entity
//@NoArgsConstructor
////@Document // Mongodb document (it tells that it is the database)
//public class Product {
//
//    @Id // primary key
//    private int productId;
//    private String productName;
//    private int price;
//
//}


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="table_1") // (we can specify table name here or else it will take the class name as table name)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id, no need to write or give id value manually
    private Integer productId;
    private String productName;
    private Integer price;
    private String productDesc;
    private String brand;
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // date format
    private Date releaseDate;
    private Boolean available;
    private Integer productQuantity;

    private String imageName;
    private String imageType;
    private byte[] imageData;
}


