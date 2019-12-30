package spring.boot.entity.dto.service;

import spring.boot.entity.dto.dto.AddressDto;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.exception.AddressException;

import java.util.List;

public interface AddressService {
    EntityDtoResponse<List<AddressDto>> findAll();

    EntityDtoResponse<AddressDto> findUserById(Long id) throws AddressException.NotFoundException;

    EntityDtoResponse<AddressDto> saveAddress(AddressDto addressDto) throws AddressException.PersistException;

}
