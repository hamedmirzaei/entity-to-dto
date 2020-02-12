package spring.boot.entity.dto.configs.interceptor;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.boot.entity.dto.annotations.Limited;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestLimitInterceptor implements HandlerInterceptor {
    private HashMap<String, List<Date>> requests = new HashMap<>();

    @Override
    public synchronized boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HandlerMethod handlerMethod;
        Method method;
        if (handler instanceof HandlerMethod) {
            handlerMethod = (HandlerMethod) handler;
            method = handlerMethod.getMethod();
        } else {
            return true;
        }
        if (method.isAnnotationPresent(Limited.class) ||
                method.getDeclaringClass().isAnnotationPresent(Limited.class)) {

            Limited limitedData = method.isAnnotationPresent(Limited.class) ?
                    method.getAnnotation(Limited.class) : method.getDeclaringClass().getAnnotation(Limited.class);

            String ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }

            String params = Lists.newArrayList(method.getParameterTypes())
                    .stream()
                    .map(Class::getSimpleName)
                    .collect(Collectors.joining(","));

            String key = method.getDeclaringClass().getSimpleName() +
                    "." + method.getName() + "(" + params + ")-" + ipAddress;

            if (!requests.containsKey(key)) {
                requests.put(key, new ArrayList<>());
            }

            List<Date> list = requests.get(key);
            Date nowDate = new Date();
            list.add(nowDate);// add current request to the list of requests
            Date start = new Date(nowDate.getTime() - 60000);
            // count number of requests since the last 60 secs
            long count = list.stream().filter(x -> x.after(start)).count();

            // remove all the requests aged more than 60 secs
            list.removeAll(list.stream().filter(x -> x.before(start)).collect(Collectors.toList()));

            if (count > limitedData.requestsPerMinute()) {
                response.setStatus(429);
                return false;
            }
        }

        return true;
    }
}
