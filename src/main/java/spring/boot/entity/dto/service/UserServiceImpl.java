package spring.boot.entity.dto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.entity.dto.domain.UserEntity;
import spring.boot.entity.dto.dto.EntityDtoResponse;
import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.exception.UserException;
import spring.boot.entity.dto.mapper.UserMapper;
import spring.boot.entity.dto.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /*
     * (non-Javadoc)
     * @see spring.boot.entity.dto.service.UserService#findAll()
     */
    @Override
    public EntityDtoResponse<List<UserDto>> findAll() {
        return new EntityDtoResponse<>(UserMapper.INSTANCE.toDTOs(userRepository.findAll()));
    }

    /*
     * (non-Javadoc)
     * @see spring.boot.entity.dto.service.UserService#findUserById(java.lang.Long)
     */
    @Override
    public EntityDtoResponse<UserDto> findUserById(Long id) throws UserException.NotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserException.NotFoundException(id));
        UserDto userDto = UserMapper.INSTANCE.toDTO(userEntity);
        return new EntityDtoResponse<>(userDto);
    }

    /*
     * (non-Javadoc)
     * @see spring.boot.entity.dto.service.UserService#saveUser(spring.boot.entity.dto.dto.UserDto)
     */
    @Override
    public EntityDtoResponse<UserDto> saveUser(UserDto userDto) throws UserException.DuplicateUsernameException {
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDto);
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new UserException.DuplicateUsernameException(userEntity.getUsername());
        }
        return new EntityDtoResponse<>(userDto);
    }

}
