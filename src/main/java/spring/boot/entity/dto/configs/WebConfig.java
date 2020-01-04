package spring.boot.entity.dto.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.boot.entity.dto.configs.interceptor.LoggerInterceptor;
import spring.boot.entity.dto.configs.interceptor.MaintenanceTimeInterceptor;
import spring.boot.entity.dto.configs.interceptor.RestCallForbiddenInterceptor;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final RestCallForbiddenInterceptor restCallForbiddenInterceptor;
    private final MaintenanceTimeInterceptor maintenanceTimeInterceptor;
    private final LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).order(Ordered.HIGHEST_PRECEDENCE);
        registry.addInterceptor(restCallForbiddenInterceptor).order(Ordered.HIGHEST_PRECEDENCE + 1);
        registry.addInterceptor(maintenanceTimeInterceptor).order(Ordered.HIGHEST_PRECEDENCE + 2);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
