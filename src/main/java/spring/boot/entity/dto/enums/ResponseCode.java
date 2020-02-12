package spring.boot.entity.dto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {
    UNKNOWN_ERROR("USR-XXXX"),
    SUCCESS("USR-0000"),
    INTERNAL_SERVER_ERROR("USR-0001"),
    USER_NOT_FOUND_ERROR("USR-0002"),
    DUPLICATE_USERNAME_ERROR("USR-0003"),
    ADDRESS_NOT_FOUND_ERROR("USR-0004"),
    VALIDATION_ERROR("USR-0005");

    String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @JsonValue
    public String toValue() {
        return this.code;
    }
}
