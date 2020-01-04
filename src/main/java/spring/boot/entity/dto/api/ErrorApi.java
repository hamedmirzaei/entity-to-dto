package spring.boot.entity.dto.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.entity.dto.dto.ErrorResponse;

@RestController
@RequestMapping("/error")
@RequiredArgsConstructor
@Api(value = "Error API", tags = {"Error Controller"})
public class ErrorApi {

    @GetMapping(value = "/maintenance", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Maintenance Time", response = ErrorResponse.class)
    public ErrorResponse returnMessageForMaintenance() {
        return new ErrorResponse("The site is under maintenance. come back later.");
    }

    @GetMapping(value = "/forbidden", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rest Call is Forbidden", response = ErrorResponse.class)
    public ErrorResponse returnMessageForForbidden() {
        return new ErrorResponse("The rest call is forbidden.");
    }

}
