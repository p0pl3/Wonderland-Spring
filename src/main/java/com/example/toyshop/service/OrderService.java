package com.example.toyshop.service;

import com.example.toyshop.dto.OrderDTO;
import com.example.toyshop.entity.Order;
import com.example.toyshop.repository.OrderRepository;
import com.example.toyshop.service.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private OrderMapper mapper;


    public OrderDTO create(OrderDTO orderDTO) {
        return mapper.toDto(repository.save(mapper.toEntity(orderDTO)));
    }

    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<OrderDTO> findAllByUserId(Long id) {
        return repository.findAllByBuyerId(id).stream().map(mapper::toDto).collect(Collectors.toList());

    }

    public OrderDTO findById(Long id){
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public Order update(Order order) {
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
