package com.ncai.cheko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {
    T data;
    List<String> errors;
    String message;

    public static <T> ResponseEntity<ApiResponse<T>> getSuccessResponse(T data) {
        return getResponse(data, Collections.emptyList(), HttpStatus.OK, null);
    }

    private static <T> ResponseEntity<ApiResponse<T>> getResponse(
            T data, List<String> errors, HttpStatus httpStatus, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setErrors(errors);
        response.setMessage(message);

        return new ResponseEntity<>(response, httpStatus);
    }
}
