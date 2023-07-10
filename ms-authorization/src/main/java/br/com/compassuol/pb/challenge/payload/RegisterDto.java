package br.com.compassuol.pb.challenge.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private Long id;
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 3, message = "First name should have at least 3 characters")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be empty")
    @Size(min = 3, message = "Last name should have at least 3 characters")
    private String lastName;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Provide a valid email")
    private String email;
    @NotEmpty(message = "Password a valid email")
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;
    private Set<RoleDto> roles;
}
