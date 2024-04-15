package marc.dev.emailapp.service;

import lombok.RequiredArgsConstructor;
import marc.dev.emailapp.domain.Confirmation;
import marc.dev.emailapp.domain.User;
import marc.dev.emailapp.repository.ConfirmationRepository;
import marc.dev.emailapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;
    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
            user.setEnabled(false);
            userRepository.save(user);

            Confirmation confirmation = new Confirmation(user);
            confirmationRepository.save(confirmation);

            /* Send email to the user with token */

//        emailService.sendSimpleMailMessage(user.getName(), user.getEmail(), confirmation.getToken());
//        emailService.sendSimpleMailMessageWithAttachments(user.getName(), user.getEmail(), confirmation.getToken());
//          emailService.sendSimpleMailMessageWithAttachments();
//        emailService.sendHtmlMail(user.getName(),user.getEmail(), confirmation.getToken());
        emailService.sendHtmlMailMessageWithEmbeddedFiles(user.getName(),user.getEmail(), confirmation.getToken());



        return user;



    }

    @Override
    @Transactional
    public String DeleteUser(Long id) {
        confirmationRepository.deleteByUserId(id);
        userRepository.deleteById(id);
        return "User has been removed";
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = userRepository.findUserByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
        return Boolean.TRUE;
    }



}
