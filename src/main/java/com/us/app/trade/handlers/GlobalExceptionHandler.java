package com.us.app.trade.handlers;

import com.us.app.trade.dto.ApiError;
import com.us.app.trade.dto.TradeSummaryResponse;
import com.us.app.trade.dto.TradeSummaryResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TradeSummaryResponse handle(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> messages = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return buildWeatherResponseVOError(messages);
    }


/*    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public TradeSummaryResponse handle(BadCredentialsException exception) {
        String message = exception.getMessage();
        return buildWeatherResponseVOError(List.of(message));
    }*/


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public TradeSummaryResponse handle(Exception exception) {
        return buildWeatherResponseVOError(List.of("There is some problem with services. Please try again later."));
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TradeSummaryResponse handle(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        List<String> messages = constraintViolations
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return buildWeatherResponseVOError(messages);
    }

    private Map error(Object message) {
        return Collections.singletonMap("error", message);
    }

    private TradeSummaryResponse buildWeatherResponseVOError(List<String> messages) {
        ApiError apiError = new ApiError();
        apiError.setReason(messages.get(0));
        return new TradeSummaryResponseBuilder().withError(apiError).build();
    }

}