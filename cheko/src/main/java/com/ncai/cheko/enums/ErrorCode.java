package com.ncai.cheko.enums;

import com.ncai.cheko.dto.common.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    GENERIC_INVALID_ID_INPUT(2001, "Please enter a valid ID.", HttpStatus.BAD_REQUEST),
    QUANTITY_MIN_VALUE(2002, "The quantity should be grater than zero", HttpStatus.BAD_REQUEST),
    VALIDATION_FAILED(2003, "Validation failed", HttpStatus.BAD_REQUEST),
    DUPLICATE_ITEM_ID(2004, "DUPLICATE_ITEM_ID", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER(5000, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String defaultMessage;
    private final HttpStatus httpStatus;


    public ErrorResponse toResponse() {
        return new ErrorResponse(String.valueOf(code), defaultMessage);
    }
}
