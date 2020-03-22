package com.spring.unittest;

import com.spring.unittest.repository.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentTest {

    private MockMvc mockMvc;

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    StudentTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void whengetStudentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/get/student/{studentId}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Kasun Dissanayake"));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(StatusCode.S200.toString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.statusCode").value(new Employee()));
    }

}
