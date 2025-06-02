package com.telconova.supportsuite.config;

import com.telconova.supportsuite.model.AgeEstimation;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    @Primary
    public RestTemplate mockRestTemplate() {
        RestTemplate mockTemplate = Mockito.mock(RestTemplate.class);
        
        // Mock respuestas para algunos nombres comunes
        mockAgifyResponse(mockTemplate, "ricardo", 41, 52981);
        mockAgifyResponse(mockTemplate, "ana", 38, 67854);
        mockAgifyResponse(mockTemplate, "juan", 42, 89123);
        mockAgifyResponse(mockTemplate, "maria", 40, 91234);
        
        return mockTemplate;
    }
    
    private void mockAgifyResponse(RestTemplate template, String name, int age, int count) {
        String url = "https://api.agify.io/?name=" + name;
        AgeEstimation response = new AgeEstimation(name, age, count);
        when(template.getForObject(eq(url), eq(AgeEstimation.class)))
                .thenReturn(response);
    }
}