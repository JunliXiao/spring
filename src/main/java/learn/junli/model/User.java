package learn.junli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;

    private String username;

    private String password;

    private String fullname;
}
