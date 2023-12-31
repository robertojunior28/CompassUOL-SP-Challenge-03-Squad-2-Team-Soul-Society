package br.com.compassuol.pb.challenge.security;

import br.com.compassuol.pb.challenge.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User userModel){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("Authorization")
                    .withSubject(userModel.getEmail())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;


        } catch (JWTCreationException exception) {
            throw new RuntimeException("ERROR WHILE GENERATING TOKEN", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("Authorization")
                    .build()
                    .verify(token)
                    .getSubject();
        }

        catch (JWTVerificationException exception) {
            return "";
        }
    }

    public boolean isValid(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Date expirationDate = JWT.require(algorithm)
                    .withIssuer("Authorization")
                    .build()
                    .verify(token)
                    .getExpiresAt();

            Date now = new Date();
            return now.before(expirationDate);
        } catch (JWTVerificationException exception) {
            return false;
        }
    }


    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}