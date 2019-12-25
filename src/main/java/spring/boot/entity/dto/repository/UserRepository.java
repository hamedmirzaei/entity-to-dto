package spring.boot.entity.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.entity.dto.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
