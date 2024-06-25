package com.revature.Service;

import com.revature.Model.Users;

public interface AmazonUserServiceInterface {
   // String loginUser(Users auser);

    Users addUser(Users incominguser);

    Object loginUser(Users incominguser,OtpService otpService);

    Object deleteUser(long userId);

    Object getAllUsers();

    Object updateUserByIdServive(Users user, long userId);
}
