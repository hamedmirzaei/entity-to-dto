package spring.boot.entity.dto.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.dto.AddressDto;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.exception.AddressException;
import spring.boot.entity.dto.mapper.AddressMapper;
import spring.boot.entity.dto.repository.AddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    @NonNull
    private AddressRepository addressRepository;

    @Override
    public EntityDtoResponse<List<AddressDto>> findAll() {
        return new EntityDtoResponse<>(AddressMapper.INSTANCE.toDTOs(addressRepository.findAll()));
    }

    @Override
    public EntityDtoResponse<AddressDto> findUserById(Long id) throws AddressException.NotFoundException {
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() -> new AddressException.NotFoundException(id));
        AddressDto addressDto = AddressMapper.INSTANCE.toDTO(addressEntity);
        return new EntityDtoResponse<>(addressDto);
    }

    @Override
    public EntityDtoResponse<AddressDto> saveAddress(AddressDto addressDto) {
        addressRepository.save(AddressMapper.INSTANCE.toEntity(addressDto));
        return new EntityDtoResponse<>(addressDto);
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
