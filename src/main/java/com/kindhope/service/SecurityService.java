package com.kindhope.service;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface SecurityService {
    String findLoggedInUserEmail();

    void autologin(String email, String password);
}
