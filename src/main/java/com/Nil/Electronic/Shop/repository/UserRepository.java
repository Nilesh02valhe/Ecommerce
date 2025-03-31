package com.Nil.Electronic.Shop.repository;

import com.Nil.Electronic.Shop.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);
    Optional <User> findByEmailAndPassword(String email, String password);

    List<User> findByNameContaining (String keywords);
}
