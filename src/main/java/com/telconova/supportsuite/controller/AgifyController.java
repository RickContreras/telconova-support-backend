package com.telconova.supportsuite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telconova.supportsuite.model.AgeEstimation;
import com.telconova.supportsuite.service.AgifyService;

@RestController
@RequestMapping("/api/age")
public class AgifyController {

    private final AgifyService agifyService;

    @Autowired
    public AgifyController(AgifyService agifyService) {
        this.agifyService = agifyService;
    }

    @GetMapping("/estimate")
    public ResponseEntity<AgeEstimation> estimateAge(@RequestParam String name) {
        AgeEstimation ageEstimation = agifyService.getAgeEstimation(name);
        return ResponseEntity.ok(ageEstimation);
    }
}