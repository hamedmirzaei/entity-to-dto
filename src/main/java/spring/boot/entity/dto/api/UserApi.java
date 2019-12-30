package spring.boot.entity.dto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.exception.UserException;
import spring.boot.entity.dto.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityDtoResponse<List<UserDto>> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityDtoResponse<UserDto> getUser(@PathVariable Long id) throws UserException.NotFoundException {
        return userService.findUserById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EntityDtoResponse<UserDto> saveUser(@RequestBody UserDto userDto) throws UserException.DuplicateUsernameException {
        return userService.saveUser(userDto);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
