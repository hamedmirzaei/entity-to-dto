package spring.boot.entity.dto.enums.converter;

import spring.boot.entity.dto.enums.ResponseCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ErrorCodeConverter implements AttributeConverter<ResponseCode, String> {

    @Override
    public String convertToDatabaseColumn(ResponseCode responseCode) {
        if (responseCode == null) {
            return null;
        }
        return responseCode.getCode();
    }

    @Override
    public ResponseCode convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ResponseCode.values())
                .filter(s -> s.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
