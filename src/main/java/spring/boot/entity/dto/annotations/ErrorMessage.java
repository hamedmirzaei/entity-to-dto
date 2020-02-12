package spring.boot.entity.dto.annotations;

import spring.boot.entity.dto.enums.ResponseCode;
import spring.boot.entity.dto.enums.ResponseMessageKey;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ErrorMessage {
    ResponseCode code() default ResponseCode.UNKNOWN_ERROR;

    ResponseMessageKey messageKey() default ResponseMessageKey.UNKNOWN_ERROR;
}
