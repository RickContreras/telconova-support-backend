package com.telconova.supportsuite.controller;

import com.telconova.supportsuite.config.SecurityConfig;
import com.telconova.supportsuite.model.AgeEstimation;
import com.telconova.supportsuite.service.AgifyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AgifyController.class)
@Import(SecurityConfig.class) // Importa la configuración de seguridad personalizada
public class AgifyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AgifyService agifyService;

    @Test
    @WithMockUser // Simula un usuario autenticado
    public void estimateAge_shouldReturnValidResponse() throws Exception {
        // Arrange
        String testName = "ricardo";
        AgeEstimation mockEstimation = new AgeEstimation(testName, 41, 52981);
        when(agifyService.getAgeEstimation(anyString())).thenReturn(mockEstimation);

        // Act & Assert
        mockMvc.perform(get("/api/age/estimate")
                        .param("name", testName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testName)))
                .andExpect(jsonPath("$.age", is(41)))
                .andExpect(jsonPath("$.count", is(52981)));
    }

    @Test
    @WithMockUser // Simula un usuario autenticado
    public void estimateAge_withoutNameParam_shouldReturnBadRequest() throws Exception {
        mockMvc.perform(get("/api/age/estimate"))
                .andExpect(status().isBadRequest());
    }
}