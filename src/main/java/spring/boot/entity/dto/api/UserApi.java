package spring.boot.entity.dto.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.boot.entity.dto.annotations.Authorize;
import spring.boot.entity.dto.annotations.Limited;
import spring.boot.entity.dto.annotations.RestCallForbidden;
import spring.boot.entity.dto.api.dto.UserDto;
import spring.boot.entity.dto.api.requests.SaveUserRequest;
import spring.boot.entity.dto.api.responses.ApplicationResponse;
import spring.boot.entity.dto.enums.Role;
import spring.boot.entity.dto.exception.UserException;
import spring.boot.entity.dto.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Api(value = "User Management API", tags = {"User Controller"})
public class UserApi {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a list of all users", response = ApplicationResponse.class)
    @Limited(requestsPerMinute = 4)
    public ApplicationResponse<List<UserDto>> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/forbidden", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a list of all users - Forbidden Version", response = ApplicationResponse.class)
    @RestCallForbidden
    public ApplicationResponse<List<UserDto>> getAllUsersForbidden() {
        return userService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a user by its id", response = ApplicationResponse.class)
    public ApplicationResponse<UserDto> getUser(@PathVariable Long id) throws UserException.NotFoundException {
        return userService.findUserById(id);
    }

    @GetMapping(value = "{id}/cached", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a user by its id - cached support", response = ApplicationResponse.class)
    @Cacheable(value = "user")
    public ApplicationResponse<UserDto> getUserCached(@PathVariable Long id)
            throws UserException.NotFoundException, InterruptedException {
        Thread.sleep(20000);
        return userService.findUserById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "add a user", response = ApplicationResponse.class)
    @Authorize(roles = {Role.ADMIN})
    public ApplicationResponse<UserDto> saveUser(@Valid @RequestBody SaveUserRequest saveUserRequest)
            throws UserException.DuplicateUsernameException {
        return userService.saveUser(saveUserRequest);
    }

}
