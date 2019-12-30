package spring.boot.entity.dto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
    UNKNOWN("USR-XXXX"),
    SUCCESS("USR-0000"),
    USER_NOT_FOUND("USR-0001"),
    DUPLICATE_USERNAME("USR-0002"),
    ADDRESS_NOT_FOUND("USR-0003"),
    ADDRESS_PERSIST_ERROR("USR-0004");

    String code;

    ErrorCode(String code) {
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
