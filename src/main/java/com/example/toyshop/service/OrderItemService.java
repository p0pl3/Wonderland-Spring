package com.example.toyshop.service;

import com.example.toyshop.dto.OrderItemCreateDTO;
import com.example.toyshop.entity.OrderItem;
import com.example.toyshop.repository.OrderItemRepository;
import com.example.toyshop.service.mapper.OrderItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository repository;
    private final ProductService productService;
    private final OrderItemMapper mapper;

    public OrderItem create(OrderItemCreateDTO dto) {
        OrderItem orderItem = mapper.toEntity(dto);
        orderItem.setProduct(productService.findById(dto.getProductId()));
        return repository.save(mapper.toEntity(dto));
    }

}
