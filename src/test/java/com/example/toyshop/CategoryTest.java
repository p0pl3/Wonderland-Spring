package com.example.toyshop;

import com.example.toyshop.dto.category.CategoryCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CategoryTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testCreateCategory() throws Exception {
        CategoryCreateDTO categoryCreateDTO = new CategoryCreateDTO();
        categoryCreateDTO.setTitle("cat1");
        categoryCreateDTO.setSlug("cat1");
        String requestBody = objectMapper.writeValueAsString(categoryCreateDTO);
        mockMvc.perform(post("/category/").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isForbidden());
    }
    @Test
    void testAllCats() throws Exception {
        mockMvc.perform(get("/category/list")).andExpect(status().isOk());
    }
    @Test
    void testDeleteCategory() throws Exception {
        mockMvc.perform(delete("/category/1")).andExpect(status().isForbidden());
    }
}
