package com.alura.api.domain.infra.security;

import com.alura.api.domain.topic.validators.IntegrityValidator;
import com.alura.api.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro alura")
                    .withSubject(user.getName())
                    .withClaim("id", user.getId())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new IntegrityValidator("Error with token");
        }
    }

    public String getSubject(String token) { // valida si el user inicio sesion
        if(token == null) {
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("foro alura")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        if(verifier.getSubject() == null) {
            throw new RuntimeException("Verifier is invalid");
        }
        return verifier.getSubject();
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(15).toInstant(ZoneOffset.of("-05:00"));
    }
}
