package com.Nil.Electronic.Shop.service.ServiceImpl;

import com.Nil.Electronic.Shop.dto.PageableResponse;
import com.Nil.Electronic.Shop.dto.UserDto;
import com.Nil.Electronic.Shop.entity.User;
import com.Nil.Electronic.Shop.exception.ResourceNotFoundException;
import com.Nil.Electronic.Shop.repository.UserRepository;
import com.Nil.Electronic.Shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
//    private ModelMapper mapper;
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
                .userId(String.valueOf(savedUser.getUserId()))
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
    public UserDto updateUser(UserDto userDto, String userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("not fount user id"));
        user.setName(userDto.getName());

        user.setGender(userDto.getGender());
        user.setImageName(userDto.getImageName());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        User updateUser= userRepository.save(user);
        UserDto updateDto= EntityToDto(updateUser);
        return updateDto;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user id is not found"));

    }

    @Override
    public PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDIr) {
        Sort sort = (sortDIr.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());

        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        Page<User> page = userRepository.findAll(pageable);
        List<User> users = page.getContent();
        List<UserDto> dtoList = users.stream().map(user -> EntityToDto(user)).collect(Collectors.toList());
        return (PageableResponse<UserDto>) dtoList;
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Cant find By userId"));
        return EntityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user not found email And Password"));
        return EntityToDto(user);
    }

    @Override
    public List<UserDto> seachUser(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> dtoList = users.stream().map(user -> EntityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }
}
