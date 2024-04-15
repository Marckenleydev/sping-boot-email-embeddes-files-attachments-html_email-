package marc.dev.emailapp.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@Table(name = "Users")
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean Enabled;

}
