package com.jolmoz.objectdetectmodeltrainer.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.jolmoz.objectdetectmodeltrainer.dtos.UserAccessDTO;
import com.jolmoz.objectdetectmodeltrainer.utils.RestTemplateClient;

@Service
public class AuthenticationControl {

    @Value("${external.auth.url}")
    String authUrl;

    @Value("${external.auth.validation.url}")
    String authValidateUrl;

    public ResponseEntity<String> login(String basicAuth) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", basicAuth);
        ResponseEntity<String> tokenResponse = RestTemplateClient.consumeRestService(authUrl, headers, "POST",
                String.class, null);
        return tokenResponse;
    }

    public ResponseEntity<UserAccessDTO> verifyToken(String token) throws IllegalAccessException, RestClientException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        ResponseEntity<UserAccessDTO> user = RestTemplateClient.consumeRestService(authValidateUrl, headers, "GET",
                UserAccessDTO.class,
                null);
        return user;
    }

}
