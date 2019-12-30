package spring.boot.entity.dto.annotations;

import spring.boot.entity.dto.enums.ErrorCode;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ErrorMessage {
    ErrorCode code() default ErrorCode.UNKNOWN;
}
