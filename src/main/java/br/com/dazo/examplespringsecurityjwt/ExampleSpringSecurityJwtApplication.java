package br.com.dazo.examplespringsecurityjwt;

import br.com.dazo.examplespringsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ExampleSpringSecurityJwtApplication {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        userService.initUsers();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringSecurityJwtApplication.class, args);
    }

}
