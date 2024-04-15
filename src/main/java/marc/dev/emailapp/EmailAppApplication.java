package marc.dev.emailapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class EmailAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAppApplication.class, args);
	}


}
