package com.Nil.Electronic.Shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {

    @Id
    private String userId;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email", unique = true)
    private String email;

    @Column(name="user_password",length = 10)
    private String password;

    private String gender;

    @Column(length = 10000)
    private String about;

    @Column(name="User_image_name")
    private String imageName;

}
