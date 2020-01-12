package spring.boot.entity.dto.configs.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.boot.entity.dto.annotations.Authorize;
import spring.boot.entity.dto.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod;
        Method method;
        if (handler instanceof HandlerMethod) {
            handlerMethod = (HandlerMethod) handler;
            method = handlerMethod.getMethod();
        } else {
            return true;
        }

        if (method.isAnnotationPresent(Authorize.class) || method.getDeclaringClass().isAnnotationPresent(Authorize.class)) {
            Role[] requiredRoles = method.getAnnotation(Authorize.class) != null ? method.getAnnotation(Authorize.class).roles() : method.getDeclaringClass().getAnnotation(Authorize.class).roles();
            // when no role is defined then the default behaviour is to consider all the roles as authorized
            if (requiredRoles == null || requiredRoles.length == 0) {
                requiredRoles = Role.values();
            }

            // if any rules matched
            for (Role role : requiredRoles) {
                if (getUserRole() == role) {
                    return true;
                }
            }
            return false;//do not continue, it may raise an exception here
        } else {
            // do not check permissions
            return true;
        }
    }

    private Role getUserRole() {
        // it should be updated with roles of a real user
        return Role.ADMIN;
    }
}
