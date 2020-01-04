package spring.boot.entity.dto.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.boot.entity.dto.configs.interceptor.MaintenanceTimeInterceptor;
import spring.boot.entity.dto.configs.interceptor.RestCallForbiddenInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RestCallForbiddenInterceptor restCallForbiddenInterceptor;
    @Autowired
    MaintenanceTimeInterceptor maintenanceTimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restCallForbiddenInterceptor).order(Ordered.HIGHEST_PRECEDENCE);
        registry.addInterceptor(maintenanceTimeInterceptor).order(Ordered.LOWEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
