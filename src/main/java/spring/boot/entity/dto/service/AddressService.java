package spring.boot.entity.dto.service;

import spring.boot.entity.dto.dto.AddressDto;
import spring.boot.entity.dto.dto.Response;
import spring.boot.entity.dto.exception.AddressException;

import java.util.List;

public interface AddressService {
    Response<List<AddressDto>> findAll();

    Response<AddressDto> findUserById(Long id) throws AddressException.NotFoundException;

    Response<AddressDto> saveAddress(AddressDto addressDto) throws AddressException.PersistException;

}
