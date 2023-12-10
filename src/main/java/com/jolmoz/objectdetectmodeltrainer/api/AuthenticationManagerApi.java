package com.jolmoz.objectdetectmodeltrainer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jolmoz.objectdetectmodeltrainer.control.AuthenticationControl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class AuthenticationManagerApi {

    @Autowired
    AuthenticationControl authControl;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("authorization") String basicAuth) {
        ResponseEntity<String> token = authControl.login(basicAuth);
        if (token.getBody().equals("false")) {
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
        }
        return token;
    }
}
