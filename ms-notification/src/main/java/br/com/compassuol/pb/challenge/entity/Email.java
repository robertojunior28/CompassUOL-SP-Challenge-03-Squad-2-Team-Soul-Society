package br.com.compassuol.pb.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fromEmail;
    @Column(nullable = false)
    private String fromName;
    @Column(nullable = false)
    private String replyTo;
    @Column(nullable = false)
    private String to;
    @Column(nullable = false)
    private String subject;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;
    @Column(nullable = false)
    private String contentType;
}
