package spring.boot.entity.dto.exception.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.configs.LocalizedMessageSource;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.enums.ErrorCode;
import spring.boot.entity.dto.exception.BaseException;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final LocalizedMessageSource localizedMessageSource;

    @ExceptionHandler(BaseException.class)
    public EntityDtoResponse<Object> handleBaseException(BaseException ex) {
        ex.printStackTrace();
        ErrorMessage errorMessage = ex.getClass().getDeclaredAnnotation(ErrorMessage.class);
        if (errorMessage != null) {
            return new EntityDtoResponse<>(errorMessage.code(), localizedMessageSource.getPersianMessage(errorMessage.messageKey(), ex.getArgs()));
        }
        return new EntityDtoResponse<>(ErrorCode.UNKNOWN, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public EntityDtoResponse<Object> handleHttpServerErrorException(Exception ex) {
        ex.printStackTrace();
        return new EntityDtoResponse<>(ErrorCode.INTERNAL_SERVER_ERROR, ex.getMessage() != null ? ex.getMessage() : localizedMessageSource.getPersianMessage("exception.internal.server.message", null));
    }

}
