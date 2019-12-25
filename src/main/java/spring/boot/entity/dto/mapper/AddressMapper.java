package spring.boot.entity.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.dto.AddressDto;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "street", target = "street"),
            @Mapping(source = "alley", target = "alley"),
            @Mapping(source = "alley", target = "floor"),
            @Mapping(source = "alley", target = "number"),
            @Mapping(source = "alley", target = "postalCode")
    })
    AddressDto toDto(AddressEntity addressEntity);

    @Mappings({
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "street", target = "street"),
            @Mapping(source = "alley", target = "alley"),
            @Mapping(source = "alley", target = "floor"),
            @Mapping(source = "alley", target = "number"),
            @Mapping(source = "alley", target = "postalCode")
    })
    AddressEntity fromDto(AddressDto addressDto);
}
