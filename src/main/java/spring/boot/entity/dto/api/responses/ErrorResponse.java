package spring.boot.entity.dto.api.responses;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    @ApiModelProperty(notes = "The response description")
    private String message;
}
