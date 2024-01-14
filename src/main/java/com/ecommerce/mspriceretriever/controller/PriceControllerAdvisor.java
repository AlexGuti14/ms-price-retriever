package com.ecommerce.mspriceretriever.controller;

import com.ecommerce.mspriceretriever.dto.ErrorDTO;
import com.ecommerce.mspriceretriever.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PriceControllerAdvisor {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PriceNotFoundException.class)
    public ErrorDTO priceNotFoundHandler(final PriceNotFoundException ex) {
        return new ErrorDTO(ex.getMessage());
    }

}