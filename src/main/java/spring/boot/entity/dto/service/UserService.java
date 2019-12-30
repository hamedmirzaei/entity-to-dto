package spring.boot.entity.dto.service;

import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.exception.UserException;

import java.util.List;

public interface UserService {
    EntityDtoResponse<List<UserDto>> findAll();

    EntityDtoResponse<UserDto> findUserById(Long id) throws UserException.NotFoundException;

    EntityDtoResponse<UserDto> saveUser(UserDto userDto) throws UserException.DuplicateUsernameException;

}
