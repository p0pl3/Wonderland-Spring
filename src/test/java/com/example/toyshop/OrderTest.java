package com.example.toyshop;

import com.example.toyshop.dto.order.OrderCreateDTO;
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
public class OrderTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testCreateOrder() throws Exception {
        OrderCreateDTO orderCreateDTO = new OrderCreateDTO();
        orderCreateDTO.setAddress("address");
        orderCreateDTO.setPhone("88888888");
        orderCreateDTO.setTotal(1000F);
        String requestBody = objectMapper.writeValueAsString(orderCreateDTO);
        mockMvc.perform(post("/product/").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isForbidden());
    }
    @Test
    void testGetOrders() throws Exception {
        mockMvc.perform(get("/orders/user/1")).andExpect(status().isForbidden());
    }
    @Test
    void testGetOrder() throws Exception {
        mockMvc.perform(get("/orders/1")).andExpect(status().isForbidden());
    }
    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/product/1")).andExpect(status().isForbidden());
    }
}
