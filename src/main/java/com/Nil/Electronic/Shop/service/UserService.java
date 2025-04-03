package com.Nil.Electronic.Shop.service;

import com.Nil.Electronic.Shop.dto.UserDto;
import com.Nil.Electronic.Shop.entity.User;

import java.net.InterfaceAddress;
import java.util.List;

public interface UserService {
    //    Create
    UserDto createUser(UserDto user);

    //    update
    UserDto updateUser(UserDto user, String userId);

    //    delete
    void deleteUser(String userId);

    //    get all Users
    List<UserDto> getAllUser(int pageNumber,int pageSize,String sortBy, String sortDIr);

    //    get single user by id
    UserDto getUserById(String userId);

    //    get single user by email
    UserDto getUserByEmail(String email);

    //    search User
    List<UserDto> seachUser(String keyword);

    //    seach user other feature

}
