package com.revature.Service;

import com.revature.Model.Product;

import java.util.List;

public interface AmazonAdminServiceInterface {

    Product addProductService(Product product);
    List<Product> getAllProductService();

    Object deleteByproductIdService(long productId);

    Object updateProductByIdServive(Product product,long productID);
}
