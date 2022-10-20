package Testwing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class RegisterDTO {
    @NotBlank(message="Username is required")
    @Size(max=50, message="Username can't be more than 50 characters.")
    private String username;
    @NotBlank(message="Email is required")
    @Size(max=50, message="email can't be more than 50 characters.")
    private String email;
    @NotBlank(message="Password is required")
    private String password;
    @NotBlank(message="Password confirmation is required")
    private String passwordConfirmation;
}
