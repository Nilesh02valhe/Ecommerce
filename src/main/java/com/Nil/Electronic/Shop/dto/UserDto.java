package com.Nil.Electronic.Shop.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class UserDto {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String about;
    private String imageName;
}
