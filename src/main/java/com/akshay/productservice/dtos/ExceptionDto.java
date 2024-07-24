package com.akshay.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    Long id;
    private String message;
    private String solution;
}
