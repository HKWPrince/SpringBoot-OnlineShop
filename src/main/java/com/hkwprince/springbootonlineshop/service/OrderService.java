package com.hkwprince.springbootonlineshop.service;

import com.hkwprince.springbootonlineshop.dto.CreateOrderRequest;
import com.hkwprince.springbootonlineshop.model.OrderDetails;
import jakarta.validation.Valid;

public interface OrderService {
     Integer createOrder(Integer userId, @Valid CreateOrderRequest createOrderRequest);

    OrderDetails getOrderById(Integer orderId);
}
