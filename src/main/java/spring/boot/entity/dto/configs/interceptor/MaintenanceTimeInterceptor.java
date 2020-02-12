package spring.boot.entity.dto.configs.interceptor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Calendar;

@Component
@ConfigurationProperties("maintenance")
@Validated
@Getter
@Setter
public class MaintenanceTimeInterceptor implements HandlerInterceptor {

    @Max(24)
    @Min(0)
    private int timeFrom;
    @Max(24)
    @Min(0)
    private int timeTo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // skip swaggers
        if (request.getRequestURI().contains("swagger"))
            return true;
        // check for maintenance time to handle it
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(cal.HOUR_OF_DAY);
        if (hour >= timeFrom && hour <= timeTo) {
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
