package spring.boot.entity.dto.exception.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.boot.entity.dto.annotations.ErrorMessage;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.enums.ErrorCode;
import spring.boot.entity.dto.exception.BaseException;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    public EntityDtoResponse<Object> handleBaseException(BaseException ex) {
        ex.printStackTrace();
        ErrorMessage errorMessage = ex.getClass().getDeclaredAnnotation(ErrorMessage.class);
        if (errorMessage != null) {
            return new EntityDtoResponse<>(errorMessage.code(), ex.getMessage());
        }
        return new EntityDtoResponse<>(ErrorCode.UNKNOWN, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public EntityDtoResponse<Object> handleHttpServerErrorException(Exception ex) {
        ex.printStackTrace();
        return new EntityDtoResponse<>(ErrorCode.INTERNAL_SERVER_ERROR, ex.getMessage() != null ? ex.getMessage(): "Internal error occurred. Call the administrator");
    }

}
