package com.revature.Service;


import com.revature.DAOs.UserDAOInterface;
import com.revature.Model.Product;
import com.revature.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AmazonUserService  implements AmazonUserServiceInterface {


    @Autowired
    private UserDAOInterface userdao;

    /*@Override
    public String loginUser(Users auser) {

        Users aa = adao.loginUser(auser.getId(), auser.getPassword());

        String result = "login is invalid";

        if (aa != null) {
            result = "login is valid";
        }
        return result;
    }*/

    /*@Override
    public String loginUser(Users auser) {
        return "";
    }*/

    @Override
    public Users addUser(Users incominguser) {

        if(incominguser.getName().isBlank() || incominguser.getName()==null){
            throw  new IllegalArgumentException("Username Cannot be empty");

        }

        if(incominguser.getPassword().isBlank() || incominguser.getPassword()==null){
            throw  new IllegalArgumentException("Password  Cannot be empty");

        }

        if(incominguser.getEmail().isBlank() || incominguser.getEmail()==null){
            throw  new IllegalArgumentException("User Email Cannot be empty");

        }



        System.out.println("before add new user");

        Users newUser = new Users(incominguser.getName(),incominguser.getPassword(),incominguser.getEmail());
        System.out.println("After create new user");

        return userdao.save(newUser);


    }

    @Override
    public Object loginUser(Users incominguser,OtpService otpService) {
        Users u =userdao.loginByUserNameAndPassword(incominguser.getName(),incominguser.getPassword());

        String otp = otpService.generateOtp();
        System.out.println("OTP: "+ otp + "Email:"+u.getEmail());
        otpService.sendOtpEmail(u.getEmail(),"OTP Verification", otp);

        System.out.println("u here: "+u);
        return u ;
    }

    @Override
    public Object deleteUser(long userId) {

        Optional<Users> b = userdao.findById(userId);
        if (b.isEmpty()) {
            return ResponseEntity.status(404).body("No product at ID " + userId + "found");
        }

        Users u = b.get();

        userdao.deleteById(userId);
        return ResponseEntity.ok().body(u.getName() + " deleted from Products");
    }

    @Override
    public Object getAllUsers() {
        return userdao.findAll();
    }

    @Override
    public Object updateUserByIdServive(Users incomingUser, long userId) {
        Optional<Users> u = userdao.findById(userId);
        if (u.isEmpty()) {
            return ResponseEntity.status(404).body("No product at ID " + userId + "found");
        }
        Users u1=u.get();

        u1.setName(incomingUser.getName());
        u1.setEmail(incomingUser.getEmail());


        userdao.save(u1);

        return u1;
    }
}
