package com.telconova.supportsuite.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.telconova.supportsuite.model.AgeEstimation;

@Service
public class AgifyService {

    private final RestTemplate restTemplate;
    private static final String AGIFY_API_URL = "https://api.agify.io/";

    @Autowired
    public AgifyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AgeEstimation getAgeEstimation(String name) {
        String url = AGIFY_API_URL + "?name=" + name;
        return restTemplate.getForObject(url, AgeEstimation.class);
    }
}