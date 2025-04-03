package com.Nil.Electronic.Shop.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Size(min= 3, max= 15, message ="invalid Name !!")
    private String name;
    //    @Email(message = "Invalid User Email")
    @NotBlank(message ="Email required")
    private String email;

    @NotBlank(message ="Password is required")
    private String password;

    @Size(min= 4, max= 9, message ="invalid Gender")
    private String gender;

    @NotBlank(message ="Write some thing about your self")
    private String about;

    private String imageName;
}
