package com.Nil.Electronic.Shop.controller;

import com.Nil.Electronic.Shop.dto.ApiResponceMessage;
import com.Nil.Electronic.Shop.dto.ApiResponceMessage;
import com.Nil.Electronic.Shop.dto.PageableResponse;
import com.Nil.Electronic.Shop.dto.UserDto;
import com.Nil.Electronic.Shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@Controller
public class UserController {
    @Autowired
    private UserService userService;
//    create
    @PostMapping()
    public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userDto){
        UserDto userDto1 = userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

//    update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable ("userId") String userId,
    @RequestBody UserDto userDto){
        UserDto UpdateUserDto = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(UpdateUserDto,HttpStatus.OK);
    }
//    delete
    @DeleteMapping("/{UserId}")
    public ResponseEntity<ApiResponceMessage> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        ApiResponceMessage response = ApiResponceMessage.builder()
                .massage("User deleted successfully")
                .Success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//    get all
    @GetMapping
    public ResponseEntity<PageableResponse<UserDto>> getAllUsers(
            @RequestParam (value= "PageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam (value= "PageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam (value= "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam (value= "sortDir", defaultValue = "asc", required = false) String sortDIr){
        PageableResponse<UserDto> response = userService.getAllUser(pageNumber, pageSize, sortBy, sortDIr);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//    get single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String userId){
        UserDto userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
//    get by email

@GetMapping("/email{email}")
public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
    UserDto userByEmail = userService.getUserById(email);
    return new ResponseEntity<>(userByEmail, HttpStatus.OK);
}
//    search user

@GetMapping("/search/{keywords}")
public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keywords) {
    List<UserDto> searchResults = userService.seachUser(keywords);
    return new ResponseEntity<>(searchResults, HttpStatus.OK);
}


}
