package spring.boot.entity.dto.configs;

import lombok.AllArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;
import spring.boot.entity.dto.enums.ResponseMessageKey;

import java.util.Locale;

@AllArgsConstructor
public class LocalizedMessageSource {

    private ResourceBundleMessageSource messageSource;

    public String getPersianMessage(String messageKey, Object[] args) {
        return messageSource.getMessage(messageKey, args, Locale.forLanguageTag("fa"));
    }

    public String getPersianMessage(ResponseMessageKey messageKey, Object[] args) {
        return getPersianMessage(messageKey.getMessageKey(), args);
    }

    public String getPersianMessage(String messageKey) {
        return getPersianMessage(messageKey, null);
    }

    public String getPersianMessage(ResponseMessageKey messageKey) {
        return getPersianMessage(messageKey.getMessageKey(), null);
    }

    public String getMessage(String messageKey, Object[] args) {
        return messageSource.getMessage(messageKey, args, null);
    }

    public String getMessage(ResponseMessageKey messageKey, Object[] args) {
        return getMessage(messageKey.getMessageKey(), args);
    }

    public String getMessage(String messageKey) {
        return getMessage(messageKey, null);
    }

    public String getMessage(ResponseMessageKey messageKey) {
        return getMessage(messageKey.getMessageKey(), null);
    }

}
