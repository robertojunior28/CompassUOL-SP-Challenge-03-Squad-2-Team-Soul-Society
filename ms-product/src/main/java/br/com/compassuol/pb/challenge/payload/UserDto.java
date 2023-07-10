package br.com.compassuol.pb.challenge.payload;

import br.com.compassuol.pb.challenge.entity.Role;
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
public class UserDto {

    private Long id;
    @NotEmpty
    @Size(min = 3, message = "First name should have at least 3 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 3, message = "Last name should have at least 3 characters")
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;
    private Set<Role> roles;
}
