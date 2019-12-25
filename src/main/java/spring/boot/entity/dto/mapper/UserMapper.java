package spring.boot.entity.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import spring.boot.entity.dto.domain.AddressEntity;
import spring.boot.entity.dto.domain.UserEntity;
import spring.boot.entity.dto.dto.AddressDto;
import spring.boot.entity.dto.dto.UserDto;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "address", target = "addressDto")
    })
    UserDto toDto(UserEntity userEntity);

    AddressDto toDto(AddressEntity addressEntity);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "addressDto", target = "address")
    })
    UserEntity fromDto(UserDto userDto);

    AddressEntity fromDto(AddressDto addressDto);
}
