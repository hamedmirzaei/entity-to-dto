package spring.boot.entity.dto.service;

import spring.boot.entity.dto.dto.AddressDto;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.exception.AddressException;

import java.util.List;

public interface AddressService {
    /**
     * This method returns all the address DTOs
     *
     * @return list of address DTOs
     */
    EntityDtoResponse<List<AddressDto>> findAll();

    /**
     * This method returns a specific address DTO
     *
     * @param id the {@code id} of address to be returned
     * @return the address DTO corresponding to {@code id}
     * @throws AddressException.NotFoundException in case no address exist with the input {@code id}
     */
    EntityDtoResponse<AddressDto> findAddressById(Long id) throws AddressException.NotFoundException;

    /**
     * This method saves an address DTO
     *
     * @param addressDto the input address DTO
     * @return the saved address DTO
     */
    EntityDtoResponse<AddressDto> saveAddress(AddressDto addressDto);

}
