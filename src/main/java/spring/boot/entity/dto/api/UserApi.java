package spring.boot.entity.dto.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.exception.UserException;
import spring.boot.entity.dto.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Api(value = "User Management Project", tags = {"User Controller"})
public class UserApi {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a list of all users", response = EntityDtoResponse.class)
    public EntityDtoResponse<List<UserDto>> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View a user by its id", response = EntityDtoResponse.class)
    public EntityDtoResponse<UserDto> getUser(@PathVariable Long id) throws UserException.NotFoundException {
        return userService.findUserById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "add a user", response = EntityDtoResponse.class)
    public EntityDtoResponse<UserDto> saveUser(@RequestBody UserDto userDto) throws UserException.DuplicateUsernameException {
        return userService.saveUser(userDto);
    }

}
