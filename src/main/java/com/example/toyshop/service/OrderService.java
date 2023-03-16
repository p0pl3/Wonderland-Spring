package com.example.toyshop.service;

import com.example.toyshop.dto.OrderCreateDTO;
import com.example.toyshop.dto.OrderListDTO;
import com.example.toyshop.entity.Order;
import com.example.toyshop.entity.User;
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
    private UserService userService;
    private OrderItemService orderItemService;

    public OrderCreateDTO create(OrderCreateDTO dto) {
        User buyer = userService.findById(dto.getBuyerId());
        Order order = mapper.fromCreateDto(dto);
        order.setBuyer(buyer);
        order.setOrderItems(dto.getOrderItems().stream().map(orderItemService::create).collect(Collectors.toList()));
        return mapper.toCreateDto(repository.save(order));
    }

    public List<OrderListDTO> findAll() {
        return repository.findAll().stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public List<OrderListDTO> findAllByUserId(Long id) {
        return repository.findAllByBuyerId(id).stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public OrderCreateDTO findById(Long id){
        return mapper.toCreateDto(repository.findById(id).orElse(null));
    }

    public Order update(Order order) {
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
