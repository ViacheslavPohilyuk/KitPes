package org.kitpes.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.dao.EmptyResultDataAccessException;


/**
 * Created by mac on 17.05.17.
 */
@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleView() {
        return "error/empty";
    }
}
