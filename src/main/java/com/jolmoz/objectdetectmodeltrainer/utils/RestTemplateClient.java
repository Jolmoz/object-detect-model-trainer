package com.jolmoz.objectdetectmodeltrainer.utils;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.MethodNotAllowedException;

public class RestTemplateClient {

    public static <T> ResponseEntity<T> consumeRestService(String url, HttpHeaders headers, String method,
            Class<T> responseType,
            String body) throws RestClientException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = null;
        HttpMethod httpMethod = null;

        switch (method) {
            case "GET":
                requestEntity = new HttpEntity<>(headers);
                httpMethod = HttpMethod.GET;
                break;

            case "POST":
                requestEntity = new HttpEntity<>(body, headers);
                httpMethod = HttpMethod.POST;
                break;

            default:
                throw new MethodNotAllowedException(method, null);
        }

        ResponseEntity<T> response = null;
        try {
            response = restTemplate.exchange(
                    url, httpMethod, requestEntity, responseType, new Object[] {});
            if (response.getStatusCode().is2xxSuccessful()) {
                return response;
            } else {
                System.err.println(
                        "Error al consumir el servicio. Código de estado: " + response.getStatusCode().value());
                return new ResponseEntity<T>(response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            System.err.println(
                    "Error al consumir el servicio. Código de estado: " + e.getStatusCode().value());
            return new ResponseEntity<T>(e.getStatusCode());
        }

    }

    public static <T> ResponseEntity<List<T>> consumeRestService(String url, HttpHeaders headers,
            String method,
            ParameterizedTypeReference<List<T>> responseType,
            String body) throws RestClientException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = null;
        HttpMethod httpMethod = null;

        switch (method) {
            case "GET":
                requestEntity = new HttpEntity<>(headers);
                httpMethod = HttpMethod.GET;
                break;

            case "POST":
                requestEntity = new HttpEntity<>(body, headers);
                httpMethod = HttpMethod.POST;
                break;

            default:
                throw new MethodNotAllowedException(method, null);
        }

        ResponseEntity<List<T>> response = null;
        try {
            response = restTemplate.exchange(
                    url, httpMethod, requestEntity, responseType, new Object[] {});
            if (response.getStatusCode().is2xxSuccessful()) {
                return response;
            } else {
                System.err.println(
                        "Error al consumir el servicio. Código de estado: " + response.getStatusCode().value());
                return new ResponseEntity<List<T>>(response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            System.err.println(
                    "Error al consumir el servicio. Código de estado: " + e.getStatusCode().value());
            return new ResponseEntity<List<T>>(e.getStatusCode());
        }

    }
}
