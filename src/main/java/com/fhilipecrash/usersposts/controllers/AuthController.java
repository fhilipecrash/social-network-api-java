package com.fhilipecrash.usersposts.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fhilipecrash.usersposts.models.AuthRequest;
import com.fhilipecrash.usersposts.models.User;
import com.fhilipecrash.usersposts.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Object> login(@RequestBody AuthRequest user) {
        User loginUser = userService.getUserByEmail(user.email);

        if (loginUser == null) {
            throw new RuntimeException("User not found");
        }

        if (!loginUser.getPassword().equals(user.password)) {
            throw new RuntimeException("Invalid password");
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(user.password);
            String token = JWT.create().withIssuer("auth0").sign(algorithm);

            Map<String, Object> filteredUser = new LinkedHashMap<>();
            filteredUser.put("id", loginUser.getId());
            filteredUser.put("name", loginUser.getName());
            filteredUser.put("email", loginUser.getEmail());

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("user", filteredUser);
            response.put("token", token);

            return response;
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
