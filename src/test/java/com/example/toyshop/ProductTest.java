package com.example.toyshop;

import com.example.toyshop.dto.product.ProductCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testCreateProduct() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setTitle("cat1");
        productCreateDTO.setPrice(100.0F);
        productCreateDTO.setCategoryId(1L);
        String requestBody = objectMapper.writeValueAsString(productCreateDTO);
        mockMvc.perform(post("/product/").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isForbidden());
    }
    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/product/list")).andExpect(status().isOk());
    }
    @Test
    void testGetFilterProducts() throws Exception {
        mockMvc.perform(get("/product/list?category=1")).andExpect(status().isOk());
    }
    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/product/1")).andExpect(status().isForbidden());
    }
}
