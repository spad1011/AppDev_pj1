package org.acme.spsp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "uzers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uzer {
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;

}
