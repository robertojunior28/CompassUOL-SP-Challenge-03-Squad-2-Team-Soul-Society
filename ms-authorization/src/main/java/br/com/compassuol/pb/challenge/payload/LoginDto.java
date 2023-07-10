package br.com.compassuol.pb.challenge.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private Long id;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Provide a valid email")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
