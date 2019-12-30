package spring.boot.entity.dto.enums.converter;

import spring.boot.entity.dto.enums.ErrorCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ErrorCodeConverter implements AttributeConverter<ErrorCode, String> {

    @Override
    public String convertToDatabaseColumn(ErrorCode errorCode) {
        if (errorCode == null) {
            return null;
        }
        return errorCode.getCode();
    }

    @Override
    public ErrorCode convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ErrorCode.values())
                .filter(s -> s.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
