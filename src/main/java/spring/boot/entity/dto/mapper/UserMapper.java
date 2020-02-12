package spring.boot.entity.dto.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import spring.boot.entity.dto.api.dto.UserDto;
import spring.boot.entity.dto.api.requests.SaveUserRequest;
import spring.boot.entity.dto.domain.SkillEntity;
import spring.boot.entity.dto.domain.UserEntity;

import java.util.List;

@Mapper(uses = {AddressMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * 1. missing attributes are skipped automatically with a warning message on output, in order to
     * skip those warnings you can skip the missing attributes explicitly using mapping annotation
     * like this: @Mapping(target = "fullName", ignore = true) which ignores fullName attribute
     * in target (i.e. here target is dto) while converting
     * <p>
     * 2. when the name changed between dto/entity it should be mentioned in the mapping annotation
     * <p>
     * 3. to convert collections to single and vice versa, you should explicitly mention the ignore
     */
    @Mappings({
            @Mapping(source = "address", target = "addressDto"),
            @Mapping(target = "skills", ignore = true)
    })
    UserDto toDTO(UserEntity userEntity);

    List<UserDto> toDTOs(List<UserEntity> userEntities);

    @Mappings({
            @Mapping(source = "addressDto", target = "address"),
            @Mapping(target = "skills", ignore = true)
    })
    UserEntity toEntity(UserDto userDto);

    @Mappings({
            @Mapping(source = "saveAddressRequest", target = "address"),
            @Mapping(target = "skills", ignore = true)
    })
    UserEntity toEntity(SaveUserRequest saveUserRequest);

    List<UserEntity> toEntities(List<UserDto> userDtos);

    /**
     * ************************************* AFTER MAPPINGS *****************************************
     */

    @AfterMapping
    default void setAfterMapping(@MappingTarget UserDto userDto, UserEntity userEntity) {
        userDto.setFullName(userEntity.getFirstName() + " " + userEntity.getLastName());
        if (userEntity.getSkills() != null)
            userDto.setSkills(userEntity.getSkills().stream().map(SkillEntity::getName)
                    .reduce((s1, s2) -> s1 + "," + s2).orElse(null));
    }

    @AfterMapping
    default void setAfterMapping(@MappingTarget UserEntity userEntity, UserDto userDto) {
        String[] nameParts = userDto.getFullName().split(" ");
        userEntity.setFirstName(nameParts[0]);
        userEntity.setLastName(nameParts[1]);
    }

    @AfterMapping
    default void setAfterMapping(@MappingTarget UserEntity userEntity, SaveUserRequest saveUserRequest) {
        String[] nameParts = saveUserRequest.getFullName().split(" ");
        userEntity.setFirstName(nameParts[0]);
        userEntity.setLastName(nameParts[1]);
    }

}
