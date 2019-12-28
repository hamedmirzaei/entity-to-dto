package spring.boot.entity.dto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.entity.dto.domain.UserEntity;
import spring.boot.entity.dto.dto.Response;
import spring.boot.entity.dto.dto.UserDto;
import spring.boot.entity.dto.exception.UserException;
import spring.boot.entity.dto.mapper.UserMapper;
import spring.boot.entity.dto.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Response<List<UserDto>> findAll() {
        return new Response<>(userRepository.findAll().stream().map(ue -> UserMapper.INSTANCE.toDto(ue)).collect(Collectors.toList()));
    }

    @Override
    public Response<UserDto> findUserById(Long id) throws UserException.NotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserException.NotFoundException(id));
        UserDto userDto = UserMapper.INSTANCE.toDto(userEntity);
        return new Response<>(userDto);
    }

    @Override
    public Response<UserDto> saveUser(UserDto userDto) throws UserException.DuplicateUsernameException {
        UserEntity userEntity = UserMapper.INSTANCE.fromDto(userDto);
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new UserException.DuplicateUsernameException(userEntity.getUsername());
        }
        return new Response<>(userDto);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
