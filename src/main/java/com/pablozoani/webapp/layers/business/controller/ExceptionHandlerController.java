package com.pablozoani.webapp.layers.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    public static final String ERROR_PAGE_URL = "error";

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView errorPage(Exception exception) {

        log.debug("errorPage()");

        log.debug(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE_URL, "exception", exception);

        return modelAndView;
    }
}
