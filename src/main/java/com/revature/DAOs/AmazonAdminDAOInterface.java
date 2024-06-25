package com.revature.DAOs;

import com.revature.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmazonAdminDAOInterface extends JpaRepository<Product,Long> {
}
