package com.example.toyshop.service;

import com.example.toyshop.dto.OrderItemDTO;
import com.example.toyshop.entity.Order;
import com.example.toyshop.entity.OrderItem;
import com.example.toyshop.repository.OrderItemRepository;
import com.example.toyshop.service.mapper.OrderItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository repository;
    private final OrderItemMapper mapper;

}
