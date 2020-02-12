package spring.boot.entity.dto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseMessageKey {
    UNKNOWN_ERROR("exception.default.message"),
    INTERNAL_SERVER_ERROR("exception.internal.server.message"),
    USER_NOT_FOUND_ERROR("exception.user.not.found.message"),
    DUPLICATE_USERNAME_ERROR("exception.user.duplicate.username.message"),
    ADDRESS_NOT_FOUND_ERROR("exception.address.not.found.message"),
    VALIDATION_ERROR("exception.validation.message");

    String messageKey;

    ResponseMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    @JsonValue
    public String toValue() {
        return this.messageKey;
    }
}
