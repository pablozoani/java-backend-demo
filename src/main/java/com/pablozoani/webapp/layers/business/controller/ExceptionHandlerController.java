package com.pablozoani.webapp.layers.business.controller;

import com.pablozoani.webapp.layers.business.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    public static final String ERROR_PAGE_URL = "error";

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView badRequest(DataIntegrityViolationException exception) {

        log.debug("badRequest()");

        log.debug(exception.getMessage());

        return new ModelAndView(ERROR_PAGE_URL, "exception", exception);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({NotFoundException.class, NumberFormatException.class})
    public ModelAndView notFound(RuntimeException exception) {

        log.debug("notFound()");

        log.debug(exception.getMessage());

        return new ModelAndView(ERROR_PAGE_URL, "exception", exception);
    }
}
