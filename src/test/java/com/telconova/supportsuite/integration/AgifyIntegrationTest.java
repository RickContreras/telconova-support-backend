package com.telconova.supportsuite.integration;

import com.telconova.supportsuite.model.AgeEstimation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AgifyIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void estimateAge_shouldReturnDataFromMockedApi() {
        // Arrange
        String testName = "ricardo";

        // Act
        ResponseEntity<AgeEstimation> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/age/estimate?name=" + testName,
                AgeEstimation.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo(testName);
        // No verificamos los valores específicos de age y count ya que
        // dependen de la respuesta real de la API externa
    }
}