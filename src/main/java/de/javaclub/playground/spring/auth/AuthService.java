package de.javaclub.playground.spring.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String auth(String username, String password) {
        return "auth" + System.currentTimeMillis();
    }
}
