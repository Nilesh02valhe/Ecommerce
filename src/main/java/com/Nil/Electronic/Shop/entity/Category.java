package com.Nil.Electronic.Shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

    private String categoryId;

    private String title;

    private String description;

    private String CoverImage;

}
