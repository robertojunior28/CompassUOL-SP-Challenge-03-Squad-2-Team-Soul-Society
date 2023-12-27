package br.com.compassuol.pb.challenge.payload;

import br.com.compassuol.pb.challenge.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto{
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
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    @Size(min = 3, message = "Password should have at least 3 characters")
    private String password;
    private List<UserRole> userRole = new ArrayList<>();
}