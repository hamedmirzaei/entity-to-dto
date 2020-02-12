package spring.boot.entity.dto.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.api.dto.AddressDto;
import spring.boot.entity.dto.api.responses.ApplicationResponse;
import spring.boot.entity.dto.exception.AddressException;
import spring.boot.entity.dto.mapper.AddressMapper;
import spring.boot.entity.dto.repository.AddressRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    @NonNull
    private AddressRepository addressRepository;

    /*
     * (non-Javadoc)
     * @see spring.boot.entity.dto.service.AddressService#findAll()
     */
    @Override
    public ApplicationResponse<List<AddressDto>> findAll() {
        return new ApplicationResponse<>(AddressMapper.INSTANCE.toDTOs(addressRepository.findAll()));
    }

    /*
     * (non-Javadoc)
     * @see spring.boot.entity.dto.service.AddressService#findAddressById(java.lang.Long)
     */
    @Override
    public ApplicationResponse<AddressDto> findAddressById(Long id) throws AddressException.NotFoundException {
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() -> new AddressException.NotFoundException(id));
        AddressDto addressDto = AddressMapper.INSTANCE.toDTO(addressEntity);
        return new ApplicationResponse<>(addressDto);
    }

    /*
     * (non-Javadoc)
     * @see spring.boot.entity.dto.service.AddressService#saveAddress(spring.boot.entity.dto.api.dto.AddressDto)
     */
    @Override
    public ApplicationResponse<AddressDto> saveAddress(AddressDto addressDto) {
        addressRepository.save(AddressMapper.INSTANCE.toEntity(addressDto));
        return new ApplicationResponse<>(addressDto);
    }
}
