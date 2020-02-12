package spring.boot.entity.dto.exception.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.api.dto.ValidationDto;
import spring.boot.entity.dto.api.responses.ApplicationResponse;
import spring.boot.entity.dto.configs.LocalizedMessageSource;
import spring.boot.entity.dto.enums.ResponseCode;
import spring.boot.entity.dto.enums.ResponseMessageKey;
import spring.boot.entity.dto.exception.BaseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final LocalizedMessageSource localizedMessageSource;
    private final String VALIDATION_PREFIX = "exception.validation.";
    private final String VALIDATION_POSTFIX = ".message";

    @ExceptionHandler(BaseException.class)
    public ApplicationResponse<Object> handleBaseException(BaseException ex) {
        ex.printStackTrace();
        ErrorMessage errorMessage = ex.getClass().getDeclaredAnnotation(ErrorMessage.class);
        if (errorMessage != null) {
            return new ApplicationResponse<>(errorMessage.code(),
                    localizedMessageSource.getPersianMessage(errorMessage.messageKey(), ex.getArgs()));
        }
        return new ApplicationResponse<>(ResponseCode.UNKNOWN_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApplicationResponse<ValidationDto> handleValidationException(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        BindingResult bindingResult = ex.getBindingResult();

        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors())
            fieldErrors.put(fieldError.getField() + ":" + fieldError.getRejectedValue(),
                    fieldError.getCodes() != null ? localizedMessageSource.getPersianMessage(
                            VALIDATION_PREFIX +
                                    fieldError.getCodes()[fieldError.getCodes().length - 1].toLowerCase() +
                                    VALIDATION_POSTFIX) : null);

        List<String> globalErrors = new ArrayList<>();
        for (ObjectError globalError : bindingResult.getGlobalErrors())
            globalErrors.add(globalError.getCodes() != null ? localizedMessageSource.getPersianMessage(
                    VALIDATION_PREFIX +
                            globalError.getCodes()[globalError.getCodes().length - 1].toLowerCase() +
                            VALIDATION_POSTFIX) : null);

        return new ApplicationResponse<>(ResponseCode.VALIDATION_ERROR,
                localizedMessageSource.getPersianMessage(ResponseMessageKey.VALIDATION_ERROR),
                new ValidationDto(fieldErrors, globalErrors));
    }

    @ExceptionHandler(Exception.class)
    public ApplicationResponse<Object> handleHttpServerErrorException(Exception ex) {
        ex.printStackTrace();
        return new ApplicationResponse<>(ResponseCode.INTERNAL_SERVER_ERROR,
                ex.getMessage() != null ? ex.getMessage() :
                        localizedMessageSource.getPersianMessage(ResponseMessageKey.INTERNAL_SERVER_ERROR));
    }

}
