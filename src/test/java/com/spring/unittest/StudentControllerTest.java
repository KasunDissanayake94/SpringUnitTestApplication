package com.spring.unittest;

import com.spring.unittest.controller.StudentController;
import com.spring.unittest.repository.StudentRepository;
import com.spring.unittest.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    StudentControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    void whenGetAllStudents() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/get/students/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());

    }

//    @BeforeEach
//    void setUp(WebApplicationContext webApplicationContext) {
//            setUp(webApplicationContext);
//
//
//        }
//
//
//    @Test
//    public void whenGetAllStudents() throws Exception
//    {
//        mockMvc.perform( MockMvcRequestBuilders
//                .get("/api/get/students/all")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//              .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());
//
//    }



    @Test
    public void whenGetStudent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/get/studentID/{studentId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.payload").exists());


    }
}
