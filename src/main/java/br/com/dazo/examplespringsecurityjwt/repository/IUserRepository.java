package br.com.dazo.examplespringsecurityjwt.repository;

import br.com.dazo.examplespringsecurityjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserName(String userName);
}
