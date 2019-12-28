package spring.boot.entity.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.dto.AddressDto;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({})
    AddressDto toDTO(AddressEntity addressEntity);

    List<AddressDto> toDTOs(List<AddressEntity> addressEntities);

    @InheritInverseConfiguration
    AddressEntity toEntity(AddressDto addressDto);
}
