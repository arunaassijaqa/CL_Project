package com.revature.Controller;

import com.revature.Model.Product;
import com.revature.Model.Users;
import com.revature.Service.AmazonAdminServiceInterface;
import com.revature.Service.AmazonUserServiceInterface;
import com.revature.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private AmazonUserServiceInterface userServiceInterface;


    @GetMapping("login")
    public ResponseEntity<Object> loginUser(@RequestBody Users incominguser) {


        // String otp = otpService.generateOtp();
        //System.out.println("OTP: "+ otp + "Email:"+incominguser.getEmail());
        //otpService.sendOtpEmail(incominguser.getEmail(),"OTP Verification", otp);


        return ResponseEntity.ok().body(userServiceInterface.loginUser(incominguser,otpService));


    }

    @PostMapping("/adduser")
    public ResponseEntity<Object> addUser(@RequestBody Users incominguser ){

        System.out.println(" inside the addUser in Controller layer");

        return ResponseEntity.ok().body(userServiceInterface.addUser(incominguser));


    }

   @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUserBYId(@PathVariable long userId)
    {
        return ResponseEntity.ok().body(userServiceInterface.deleteUser(userId));
    }

    @GetMapping("all")
    public ResponseEntity<Object> loginUser() {


        // String otp = otpService.generateOtp();
        //System.out.println("OTP: "+ otp + "Email:"+incominguser.getEmail());
        //otpService.sendOtpEmail(incominguser.getEmail(),"OTP Verification", otp);


        return ResponseEntity.ok().body(userServiceInterface.getAllUsers());


    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateProductById(@RequestBody Users user , @PathVariable long userId)
    {
        System.out.println("inside updateUser");
        return ResponseEntity.ok().body(userServiceInterface.updateUserByIdServive(user,userId));
    }




}
