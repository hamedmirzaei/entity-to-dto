package spring.boot.entity.dto.service;

import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.dto.Response;
import spring.boot.entity.dto.exception.UserException;

import java.util.List;

public interface UserService {
    Response<List<UserDto>> findAll();

    Response<UserDto> findUserById(Long id) throws UserException.NotFoundException;

    Response<UserDto> saveUser(UserDto userDto) throws UserException.DuplicateUsernameException;

}
