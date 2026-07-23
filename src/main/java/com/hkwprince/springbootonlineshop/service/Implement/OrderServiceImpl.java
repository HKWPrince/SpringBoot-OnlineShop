package com.hkwprince.springbootonlineshop.service.Implement;

import com.hkwprince.springbootonlineshop.dao.OrderDao;
import com.hkwprince.springbootonlineshop.dao.ProductDao;
import com.hkwprince.springbootonlineshop.dto.BuyItem;
import com.hkwprince.springbootonlineshop.dto.CreateOrderRequest;
import com.hkwprince.springbootonlineshop.model.OrderDetails;
import com.hkwprince.springbootonlineshop.model.OrderItem;
import com.hkwprince.springbootonlineshop.model.Product;
import com.hkwprince.springbootonlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem>  orderItemList = new ArrayList<>();
        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            // Count Amount of order
            Product tmpProduct= productDao.getProductById(buyItem.getProductId());
            int tmpAmount = tmpProduct.getPrice()*buyItem.getQuantity();
            totalAmount = totalAmount+tmpAmount;

            // Convert buyItem to OrderItem
            OrderItem tmpOrderItem = new OrderItem();
            tmpOrderItem.setProduct_id(buyItem.getProductId());
            tmpOrderItem.setQuantity(buyItem.getQuantity());
            tmpOrderItem.setAmount(tmpAmount);
            orderItemList.add(tmpOrderItem);
        }

        // Create Order
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOderItems(orderId,orderItemList);

        return orderId;


    }

    @Override
    public OrderDetails getOrderById(Integer orderId) {
        OrderDetails orderDetails =  orderDao.getOrderById(orderId);
        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        orderDetails.setOrderItemList(orderItemList);

        return orderDetails;
    }
}
