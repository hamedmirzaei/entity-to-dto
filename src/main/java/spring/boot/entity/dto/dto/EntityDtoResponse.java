package spring.boot.entity.dto.dto;

import lombok.Getter;
import lombok.Setter;
import spring.boot.entity.dto.enums.MessageCodeType;

@Getter
@Setter
public class EntityDtoResponse<T> {
    private MessageCodeType messageCode;
    private String description;
    private Long longValue;
    private String stringValue;
    private T objectValue;

    public EntityDtoResponse(MessageCodeType messageCode, String description, Long longValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.longValue = longValue;
    }

    public EntityDtoResponse(MessageCodeType messageCode, String description, String stringValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.stringValue = stringValue;
    }

    public EntityDtoResponse(MessageCodeType messageCode, String description, T objectValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.objectValue = objectValue;
    }

    public EntityDtoResponse(MessageCodeType messageCode, String description) {
        this.messageCode = messageCode;
        this.description = description;
    }

    public EntityDtoResponse(Long longValue) {
        setSuccess();
        this.longValue = longValue;
    }

    public EntityDtoResponse(String stringValue) {
        setSuccess();
        this.stringValue = stringValue;
    }

    public EntityDtoResponse(T objectValue) {
        setSuccess();
        this.objectValue = objectValue;
    }

    private void setSuccess() {
        this.messageCode = MessageCodeType.SUCCESS;
        this.description = "Successfully done";
    }

    public MessageCodeType getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(MessageCodeType messageCode) {
        this.messageCode = messageCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public T getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(T objectValue) {
        this.objectValue = objectValue;
    }
}
