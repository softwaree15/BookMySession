package com.bookmysession.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseStatusExceptionHandlerUtil extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ ResponseStatusException.class })
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        Map<String, Object> errorResponse = new HashMap<String, Object>();

        errorResponse.put("timestamp", BaseUtils.dateTimeFormatter(LocalDateTime.now()));
        errorResponse.put("error", ex.getStatus());
        errorResponse.put("message", ex.getReason());
        errorResponse.put("debugMessage", ex.getLocalizedMessage());

        return new ResponseEntity<>(errorResponse, ex.getStatus());

    }
}
