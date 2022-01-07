package com.donald.transformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(HttpServletResponse res, Exception ex) throws IOException {
        res.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res, Exception ex) throws IOException {
        res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
