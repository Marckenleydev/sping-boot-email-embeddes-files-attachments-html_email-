package marc.dev.emailapp.service;

import marc.dev.emailapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User saveUser(User user);


    String DeleteUser(Long id);

    Boolean verifyToken(String token);
}
