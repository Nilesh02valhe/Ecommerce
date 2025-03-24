package com.Nil.Electronic.Shop.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String about;
    private String imageName;
}
