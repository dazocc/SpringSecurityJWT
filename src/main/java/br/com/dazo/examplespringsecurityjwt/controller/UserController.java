package br.com.dazo.examplespringsecurityjwt.controller;

import br.com.dazo.examplespringsecurityjwt.entity.AuthRequest;
import br.com.dazo.examplespringsecurityjwt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String hello() {
        return "get";
    }

    @DeleteMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete() {
        return "delete";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid UserName or Password");
        }

        return jwtUtil.generateToken(authRequest.getUserName());
    }


}
