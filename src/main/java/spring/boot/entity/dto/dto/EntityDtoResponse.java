package spring.boot.entity.dto.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import spring.boot.entity.dto.enums.ErrorCode;

@Getter
@Setter
public class EntityDtoResponse<T> {

    @ApiModelProperty(notes = "The response code")
    private ErrorCode messageCode;
    @ApiModelProperty(notes = "The response description")
    private String description;
    @ApiModelProperty(notes = "The response value when it is a long")
    private Long longValue;
    @ApiModelProperty(notes = "The response value when it is a string")
    private String stringValue;
    @ApiModelProperty(notes = "The response value when it is an object")
    private T objectValue;

    public EntityDtoResponse(ErrorCode messageCode, String description, Long longValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.longValue = longValue;
    }

    public EntityDtoResponse(ErrorCode messageCode, String description, String stringValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.stringValue = stringValue;
    }

    public EntityDtoResponse(ErrorCode messageCode, String description, T objectValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.objectValue = objectValue;
    }

    public EntityDtoResponse(ErrorCode messageCode, String description) {
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
        this.messageCode = ErrorCode.SUCCESS;
        this.description = "Successfully done";
    }

    public ErrorCode getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(ErrorCode messageCode) {
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
