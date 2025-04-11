package com.Nil.Electronic.Shop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private String categoryId;
    @NotBlank
    @Min(value=4, message="title must be of minimum 4 char")
    private String title;

    @NotBlank(message="Description Required")
    private String description;

    //	@NotBlank(message="Cover Image Required")
    private String CoverImage;
}
