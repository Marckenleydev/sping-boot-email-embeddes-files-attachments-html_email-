package marc.dev.emailapp.repository;

import marc.dev.emailapp.domain.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
    Confirmation findByToken(String token);

    String deleteByUserId(Long userId);


}
