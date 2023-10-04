package com.alura.api.controller;

import com.alura.api.domain.infra.security.JwtDataToken;
import com.alura.api.domain.infra.security.TokenService;
import com.alura.api.domain.user.User;
import com.alura.api.domain.user.UserAuthenticationData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthenticationData userAuthenticationData) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userAuthenticationData.name(), userAuthenticationData.password());
        var authenticatedUser = authenticationManager.authenticate(authenticationToken);
        var jwtToken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new JwtDataToken(jwtToken));
    }

}
