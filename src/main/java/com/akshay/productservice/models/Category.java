package com.akshay.productservice.models;

import lombok.*;

@Getter
@Setter
public class Category extends BaseModel {
    private String name;
    private String description;
}
