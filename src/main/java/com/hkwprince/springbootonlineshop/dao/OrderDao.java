package com.hkwprince.springbootonlineshop.dao;

import com.hkwprince.springbootonlineshop.model.OrderDetails;
import com.hkwprince.springbootonlineshop.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer sumAmount);

    void createOderItems(Integer orderId, List<OrderItem> orderItemList);

    OrderDetails getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
}
