package spring.boot.entity.dto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.dto.AddressDto;
import spring.boot.entity.dto.dto.Response;
import spring.boot.entity.dto.exception.AddressException;
import spring.boot.entity.dto.mapper.AddressMapper;
import spring.boot.entity.dto.repository.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public Response<List<AddressDto>> findAll() {
        return new Response<>(addressRepository.findAll().stream().map(ue -> AddressMapper.INSTANCE.toDto(ue)).collect(Collectors.toList()));
    }

    @Override
    public Response<AddressDto> findUserById(Long id) throws AddressException.NotFoundException {
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() -> new AddressException.NotFoundException(id));
        AddressDto addressDto = AddressMapper.INSTANCE.toDto(addressEntity);
        return new Response<>(addressDto);
    }

    @Override
    public Response<AddressDto> saveAddress(AddressDto addressDto) throws AddressException.PersistException {
        AddressEntity addressEntity = AddressMapper.INSTANCE.fromDto(addressDto);
        try {
            addressRepository.save(addressEntity);
        } catch (Exception e) {
            throw new AddressException.PersistException();
        }
        return new Response<>(addressDto);
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
