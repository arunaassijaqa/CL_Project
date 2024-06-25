package com.revature.Service;

import com.revature.DAOs.AmazonAdminDAOInterface;
import com.revature.Model.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AmazonAdminSercvice implements AmazonAdminServiceInterface {

    @Autowired
    private AmazonAdminDAOInterface adminDAO;

    @Override
    public Product addProductService(Product product) {
        adminDAO.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProductService() {
        return adminDAO.findAll();
    }



    @Override
    public Object updateProductByIdServive(Product incomingProduct, long productId) {
        Optional<Product> p = adminDAO.findById(productId);
        if (p.isEmpty()) {
            return ResponseEntity.status(404).body("No product at ID " + productId + "found");
        }
        Product p1=p.get();
        p1.setProductId((incomingProduct.getProductId()));
        p1.setProductname(incomingProduct.getProductname());
        p1.setProductDescription(incomingProduct.getProductDescription());
        p1.setProductPrice(incomingProduct.getProductPrice());

        adminDAO.save(p1);

        return p1;
    }

    @Override
    public Object deleteByproductIdService(long productId) {
        Optional<Product> b = adminDAO.findById(productId);
        if (b.isEmpty()) {
            return ResponseEntity.status(404).body("No product at ID " + productId + "found");
        }

        Product product = b.get();

        adminDAO.deleteById(productId);
        return ResponseEntity.ok().body(product.getProductname() + " deleted from Products");

    }
}
