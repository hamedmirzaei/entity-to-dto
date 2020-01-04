package spring.boot.entity.dto.configs.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.boot.entity.dto.annotations.RestCallForbidden;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class RestCallForbiddenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(RestCallForbidden.class) || method.getDeclaringClass().isAnnotationPresent(RestCallForbidden.class)) {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                return false;// means do not continue, it is done here
            }
        }
        return true;// means continue the handlers chain
    }
}
