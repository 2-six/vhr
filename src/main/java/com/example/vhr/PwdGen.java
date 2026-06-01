package com.example.vhr;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdGen {
    public static void main(String[] args) {
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        System.out.println(e.encode("123456"));
    }
}