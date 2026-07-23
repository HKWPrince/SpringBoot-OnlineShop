package com.hkwprince.springbootonlineshop.rowMapper;

import com.hkwprince.springbootonlineshop.model.OrderDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsRowMapper implements RowMapper<OrderDetails> {
    @Override
    public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrder_id(rs.getInt("order_id"));
        orderDetails.setUser_id(rs.getInt("user_id"));
        orderDetails.setTotal_amount(rs.getInt("total_amount"));
        orderDetails.setCreate_date(rs.getTimestamp("created_date"));
        orderDetails.setLast_modified_date(rs.getTimestamp("last_modified_date"));

        return orderDetails;
    }
}
