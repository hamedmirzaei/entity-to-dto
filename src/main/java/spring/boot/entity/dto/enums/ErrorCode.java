package spring.boot.entity.dto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
    UNKNOWN("USR-XXXX"),
    SUCCESS("USR-0000"),
    INTERNAL_SERVER_ERROR("USR-0001"),
    USER_NOT_FOUND("USR-0002"),
    DUPLICATE_USERNAME("USR-0003"),
    ADDRESS_NOT_FOUND("USR-0004"),
    ADDRESS_PERSIST_ERROR("USR-0005");

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
