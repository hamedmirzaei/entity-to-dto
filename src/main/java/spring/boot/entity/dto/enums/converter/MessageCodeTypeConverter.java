package spring.boot.entity.dto.enums.converter;

import spring.boot.entity.dto.enums.MessageCodeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class MessageCodeTypeConverter implements AttributeConverter<MessageCodeType, String> {

    @Override
    public String convertToDatabaseColumn(MessageCodeType messageCodeType) {
        if (messageCodeType == null) {
            return null;
        }
        return messageCodeType.getCode();
    }

    @Override
    public MessageCodeType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(MessageCodeType.values())
                .filter(s -> s.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
