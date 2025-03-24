package com.Nil.Electronic.Shop.repository;

import com.Nil.Electronic.Shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
