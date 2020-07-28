package com.gjm.file_cloud.exceptions.file_cloud_runtime_exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_EXTENDED)
public class FileValidationException extends RuntimeException {
    public FileValidationException(String message) {
        super(message);
    }
}
