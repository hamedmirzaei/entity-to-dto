package spring.boot.entity.dto.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RestCallForbidden {
}
