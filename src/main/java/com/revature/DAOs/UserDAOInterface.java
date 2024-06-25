package com.revature.DAOs;

import com.revature.Model.Product;
import com.revature.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAOInterface extends JpaRepository<Users,Long> {

    @Query("from com.revature.Model.Users a where a.name=:uname and a.password=:upass")
    Users loginByUserNameAndPassword(@Param("uname") String name, @Param("upass") String password);


    // Users loginUser(String id, String password);
}
