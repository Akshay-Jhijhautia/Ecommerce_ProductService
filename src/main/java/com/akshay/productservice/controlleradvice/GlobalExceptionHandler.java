package com.akshay.productservice.controlleradvice;

import com.akshay.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Global Exception Handler
// Applicable to All controllers in this project
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException() {
        return new ResponseEntity<>(
                "Arithmetic Exception",
                HttpStatus.BAD_REQUEST
        );
    }

    // Sending Custom Message
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDto> handleNullPointerException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Null Pointer Exception Has Occurred");
        exceptionDto.setSolution("Divide by zero is causing this issue");

        return new ResponseEntity<ExceptionDto>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayOutOfBoundsException() {
        return new ResponseEntity<>(
                "Array Out Of Bounds Exception",
                HttpStatus.BAD_REQUEST
        );
    }
}
