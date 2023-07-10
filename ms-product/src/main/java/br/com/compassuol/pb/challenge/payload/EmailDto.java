package br.com.compassuol.pb.challenge.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
    private Long id;
    @NotEmpty
    @Email
    private String fromEmail;
    @NotEmpty
    private String fromName;
    @NotEmpty
    private String replyTo;
    @NotEmpty
    private String to;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String body;
    private String contentType;
}