package spring.boot.entity.dto.service;

import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.exception.UserException;

import java.util.List;

public interface UserService {
    /**
     * This method returns all the user DTOs
     *
     * @return list of user DTOs
     */
    EntityDtoResponse<List<UserDto>> findAll();

    /**
     * This method returns a specific user DTO
     *
     * @param id the {@code id} of user to be returned
     * @return the user DTO corresponding to {@code id}
     * @throws UserException.NotFoundException in case no user exist with the input {@code id}
     */
    EntityDtoResponse<UserDto> findUserById(Long id) throws UserException.NotFoundException;

    /**
     * This method saves an user DTO
     *
     * @param userDto the input user DTO
     * @return the saved user DTO
     * @throws UserException.DuplicateUsernameException in case which currently an user exist with username {@code userDto.username}
     */
    EntityDtoResponse<UserDto> saveUser(UserDto userDto) throws UserException.DuplicateUsernameException;

}
