package spring.boot.entity.dto.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limited {
    int requestsPerMinute() default -1;
}
