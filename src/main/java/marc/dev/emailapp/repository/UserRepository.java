package marc.dev.emailapp.repository;

import marc.dev.emailapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
