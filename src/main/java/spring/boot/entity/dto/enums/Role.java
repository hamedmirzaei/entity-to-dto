package spring.boot.entity.dto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    USER("USER"),
    ADMIN("ADMIN");

    String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonValue
    public String toValue() {
        return this.name;
    }
}
