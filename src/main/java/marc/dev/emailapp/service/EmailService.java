package marc.dev.emailapp.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendSimpleMailMessage(String name, String to,String token);
    void sendSimpleMailMessageWithAttachments(String name, String to,String token);
    void sendSimpleMailMessageWithAttachmentsImages(String name, String to,String token);
    void sendSimpleMailMessageWithEmbeddedFiles(String name, String to,String token);
    void sendHtmlMail(String name, String to,String token);
    void sendHtmlMailMessageWithEmbeddedFiles(String name, String to,String token);

}
