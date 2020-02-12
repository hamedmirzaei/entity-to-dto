package spring.boot.entity.dto.annotations;

import spring.boot.entity.dto.validators.UsernamePasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernamePasswordValidator.class)
public @interface UsernameNotInPassword {

    String message() default "exception.validation.usernamenotinpassword.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
