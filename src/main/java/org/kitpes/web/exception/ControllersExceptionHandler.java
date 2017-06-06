package org.kitpes.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by mac on 17.05.17.
 */
@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView wrongIdentifier() {
        ModelAndView mav = new ModelAndView();

        String message = "Неправильный идентификатор!";

        mav.addObject("message", message);
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView resourceNotFound (HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        String message = "Ошибка 404!\n" +
                         "Извините, но требуемый запрос " + request.getRequestURL() + " не найден.";

        mav.addObject("message", message);
        mav.setViewName("error");
        return mav;
    }
}
