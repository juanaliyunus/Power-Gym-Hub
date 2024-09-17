package com.work.baseapp.exception;

import com.work.baseapp.dto.response.CommonResponse;
import com.work.baseapp.exception.util.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<CommonResponse<String>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        CommonResponse<String> response = CommonResponse.<String>builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
