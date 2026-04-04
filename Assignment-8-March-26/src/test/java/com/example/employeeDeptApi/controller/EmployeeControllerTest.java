package com.example.employeeDeptApi.controller;

import com.example.employeeDeptApi.controllers.EmployeeController;
import com.example.employeeDeptApi.services.EmployeeService;

import org.junit.jupiter.api.T                         est;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    void testGetAllEmployees() throws Exception {

        Mockito.when(service.getAllEmployees())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk());
    }
}