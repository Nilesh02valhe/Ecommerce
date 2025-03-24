package com.Nil.Electronic.Shop.service.ServiceImpl;

import com.Nil.Electronic.Shop.dto.UserDto;
import com.Nil.Electronic.Shop.entity.User;
import com.Nil.Electronic.Shop.repository.UserRepository;
import com.Nil.Electronic.Shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        String string = UUID.randomUUID().toString();
        User user=dtoToEntity(userDto);      // dto>Entity
        User savedUser = userRepository.save(user);
        UserDto newDto= EntityToDto (savedUser);  // Entity>Dto
        return newDto;
    }

    private UserDto EntityToDto(User savedUser) {
        UserDto userDto = UserDto.builder()
                .userId(savedUser.getUserId())
                .name(savedUser.getName())
                .about(savedUser.getAbout())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .gender(savedUser.getGender())
                .imageName(savedUser.getImageName())
                .build();
        return userDto;
    }

    private User dtoToEntity(UserDto userDto) {
        User user=User.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .about(userDto.getAbout())
                .gender(userDto.getGender())
                .imageName(userDto.getImageName())
                .build();
        return user;
        
    }

    @Override
    public UserDto updateUser(UserDto user, String userId) {

        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> seachUser(String keyword) {
        return null;
    }
}
