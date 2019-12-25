package spring.boot.entity.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.entity.dto.domain.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
