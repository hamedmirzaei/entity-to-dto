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
        // skip swaggers
        if (request.getRequestURI().startsWith("/swagger"))
            return true;
        // check for RestCallForbidden annotation to handle it
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(RestCallForbidden.class) || method.getDeclaringClass().isAnnotationPresent(RestCallForbidden.class)) {
                response.sendRedirect("/error/forbidden");
                return false;// means do not continue, it is done here
            }
        }
        return true;// means continue the handlers chain
    }
}
