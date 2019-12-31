package spring.boot.entity.dto.configs;

import lombok.AllArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@AllArgsConstructor
public class LocalizedMessageSource {

    private ResourceBundleMessageSource messageSource;

    public String getPersianMessage(String messageKey, Object[] args) {
        return messageSource.getMessage(messageKey, args, Locale.forLanguageTag("fa"));
    }

    public String getMessage(String messageKey, Object[] args) {
        return messageSource.getMessage(messageKey, args, null);
    }

}
