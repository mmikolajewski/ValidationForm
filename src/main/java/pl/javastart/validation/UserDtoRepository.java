package pl.javastart.validation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDtoRepository extends JpaRepository<UserDto, Long> {
}
