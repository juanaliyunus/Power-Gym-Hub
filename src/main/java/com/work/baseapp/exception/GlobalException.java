package com.work.baseapp.exception;

import com.work.baseapp.dto.response.CommonResponse;
import com.work.baseapp.exception.util.AuthenticationException;
import com.work.baseapp.exception.util.FileStorageException;
import com.work.baseapp.exception.util.ResourceNotFoundException;
import com.work.baseapp.exception.util.ValidationException;
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

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<CommonResponse<String >> handleValidationException(ValidationException exception){
        CommonResponse<String> response = CommonResponse.<String>builder()
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler({AuthenticationException.class})
    public  ResponseEntity<CommonResponse<String>> handleAuthenticationException(AuthenticationException exception){
        CommonResponse<String> response = CommonResponse.<String>builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler({FileStorageException.class})
    public  ResponseEntity<CommonResponse<String>> handleFileStorageException(FileStorageException exception){
        CommonResponse<String> response = CommonResponse.<String>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}