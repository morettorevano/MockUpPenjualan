package Testwing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Account {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Email",length = 50)
    private String email;

    @Column(name = "Password")
    private String password;

//    @Column(name = "Role")
//    private String role;
}
