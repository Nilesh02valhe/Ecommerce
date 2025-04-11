package com.Nil.Electronic.Shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category {
    @Id
    @Column(name="id")
    private String categoryId;
    @Column(name="category_title", length=60, nullable=false)
    private String title;
    @Column(name="category_desc", length=1000)
    private String description;

    private String CoverImage;

}
