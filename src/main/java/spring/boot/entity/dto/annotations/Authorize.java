package spring.boot.entity.dto.annotations;


import spring.boot.entity.dto.enums.Role;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorize {
    Role[] roles() default {};
}
