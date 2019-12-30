package spring.boot.entity.dto.exception.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.enums.ErrorCode;
import spring.boot.entity.dto.exception.BaseException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    public EntityDtoResponse<Object> handleUserNotFoundException(BaseException ex) {
        ErrorMessage errorMessage = ex.getClass().getDeclaredAnnotation(ErrorMessage.class);
        if (errorMessage != null) {
            return new EntityDtoResponse<>(errorMessage.code(), ex.getMessage());
        }
        return new EntityDtoResponse<>(ErrorCode.UNKNOWN, ex.getMessage());
    }

}
