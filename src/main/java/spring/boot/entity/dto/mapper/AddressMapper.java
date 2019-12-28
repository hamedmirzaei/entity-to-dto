package spring.boot.entity.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.dto.AddressDto;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({})
    AddressDto toDto(AddressEntity addressEntity);

    @InheritInverseConfiguration
    AddressEntity fromDto(AddressDto addressDto);
}
