package spring.boot.entity.dto.api.responses;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import spring.boot.entity.dto.enums.ResponseCode;

@Getter
@Setter
public class ApplicationResponse<T> {

    @ApiModelProperty(notes = "The response code")
    private ResponseCode messageCode;

    @ApiModelProperty(notes = "The response description")
    private String description;

    @ApiModelProperty(notes = "The response value when it is a long")
    private Long longValue;

    @ApiModelProperty(notes = "The response value when it is a string")
    private String stringValue;

    @ApiModelProperty(notes = "The response value when it is an object")
    private T objectValue;

    public ApplicationResponse(ResponseCode messageCode, String description, Long longValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.longValue = longValue;
    }

    public ApplicationResponse(ResponseCode messageCode, String description, String stringValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.stringValue = stringValue;
    }

    public ApplicationResponse(ResponseCode messageCode, String description, T objectValue) {
        this.messageCode = messageCode;
        this.description = description;
        this.objectValue = objectValue;
    }

    public ApplicationResponse(ResponseCode messageCode, String description) {
        this.messageCode = messageCode;
        this.description = description;
    }

    public ApplicationResponse(Long longValue) {
        setSuccess();
        this.longValue = longValue;
    }

    public ApplicationResponse(String stringValue) {
        setSuccess();
        this.stringValue = stringValue;
    }

    public ApplicationResponse(T objectValue) {
        setSuccess();
        this.objectValue = objectValue;
    }

    private void setSuccess() {
        this.messageCode = ResponseCode.SUCCESS;
        this.description = "Successfully done";
    }

    public ResponseCode getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(ResponseCode messageCode) {
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
