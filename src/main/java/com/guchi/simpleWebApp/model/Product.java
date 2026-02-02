package com.guchi.simpleWebApp.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private int productId;
    private String productName;
    private int price;
}

