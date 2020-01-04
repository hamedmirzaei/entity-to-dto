package spring.boot.entity.dto.configs.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component
public class MaintenanceTimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // skip swaggers
        if (request.getRequestURI().contains("swagger"))
            return true;
        // check for maintenance time to handle it
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(cal.HOUR_OF_DAY);
        if (hour >= 23 && hour <= 24) {
            if (request.getRequestURI().startsWith("/error"))
                return true;
            else {
                response.sendRedirect("/error/maintenance");
                return false;
            }
        }
        return true;
    }
}
