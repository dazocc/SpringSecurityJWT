package br.com.dazo.examplespringsecurityjwt.service;

import br.com.dazo.examplespringsecurityjwt.entity.UserEntity;
import br.com.dazo.examplespringsecurityjwt.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;


    public void initUsers() {
        List<UserEntity> users = Stream.of(
                new UserEntity(101, "dazo", "123", "javatechie@gmail.com"),
                new UserEntity(102, "user1", "pwd1", "user1@gmail.com"),
                new UserEntity(103, "user2", "pwd2", "user2@gmail.com"),
                new UserEntity(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());

        iUserRepository.saveAll(users);
    }
}
