package com.challenge.rewardsService.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RewardsServiceExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RewardsServiceExceptionHandler.class.getName());

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Throwable ex){
        var responseBody = new ErrorResponse();
        HttpStatus status;
        responseBody.setException(ex.getClass().getSimpleName());
        if(ex instanceof DatabaseException){
            status = HttpStatus.SERVICE_UNAVAILABLE;
            responseBody.getErrors().add(ex.getMessage());
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            String message = ex.getMessage() != null ? ex.getMessage() : "An error occurred.";
            responseBody.getErrors().add(message);
        }
        LOG.error("Error details :: " + responseBody.getErrors());
        return ResponseEntity.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody);
    }
}
