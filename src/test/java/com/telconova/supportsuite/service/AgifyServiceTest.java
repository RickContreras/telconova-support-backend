package com.telconova.supportsuite.service;

import com.telconova.supportsuite.model.AgeEstimation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgifyServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private AgifyService agifyService;

    @BeforeEach
    public void setup() {
        agifyService = new AgifyService(restTemplate);
    }

    @Test
    public void getAgeEstimation_shouldReturnCorrectData() {
        // Arrange
        String name = "ricardo";
        AgeEstimation mockResponse = new AgeEstimation("ricardo", 41, 52981);
        when(restTemplate.getForObject(anyString(), eq(AgeEstimation.class)))
                .thenReturn(mockResponse);

        // Act
        AgeEstimation result = agifyService.getAgeEstimation(name);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getAge()).isEqualTo(41);
        assertThat(result.getCount()).isEqualTo(52981);
    }
}