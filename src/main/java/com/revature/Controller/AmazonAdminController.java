package com.revature.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.revature.DAOs.AmazonAdminDAOInterface;
import com.revature.Model.Product;
import com.revature.Service.AmazonAdminServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
public class AmazonAdminController {

    @Autowired
    private AmazonAdminServiceInterface adminInterface;




    @PostMapping("/addproduct")
    public  ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        System.out.println("inside addProduct");
        return ResponseEntity.ok().body(adminInterface.addProductService(product));
    }

    @GetMapping("/allproduct")
    public ResponseEntity <List<Product>> getAllProduct()
    {
        System.out.println("inside AllProduct");
        return ResponseEntity.ok().body(adminInterface.getAllProductService());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProductById(@PathVariable long productId)
    {
        System.out.println("inside DeleteProduct");
        return ResponseEntity.ok().body(adminInterface.deleteByproductIdService(productId));
    }



    @PutMapping("/{productId}")
    public ResponseEntity<Object> updateProductById(@RequestBody Product product , @PathVariable long productId)
    {
        System.out.println("inside updateProduct");
        return ResponseEntity.ok().body(adminInterface.updateProductByIdServive(product,productId));
    }



}
