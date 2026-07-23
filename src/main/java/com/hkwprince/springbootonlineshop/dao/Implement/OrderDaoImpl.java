package com.hkwprince.springbootonlineshop.dao.Implement;

import com.hkwprince.springbootonlineshop.dao.OrderDao;
import com.hkwprince.springbootonlineshop.model.OrderDetails;
import com.hkwprince.springbootonlineshop.model.OrderItem;
import com.hkwprince.springbootonlineshop.rowMapper.OrderDetailsRowMapper;
import com.hkwprince.springbootonlineshop.rowMapper.OrderItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {

        String sql = "INSERT INTO Order_details (user_id, total_amount, created_date, last_modified_date)" +
                        "values (:user_id, :total_amount, :created_date, :last_modified_date)";

        Map<String,Object> map = new HashMap<>();

        map.put("user_id", userId);
        map.put("total_amount", totalAmount);

        Date date = new Date();

        map.put("created_date", date);
        map.put("last_modified_date", date);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int orderId = keyHolder.getKey().intValue();

        return  orderId;
    }

    @Transactional
    @Override
    public void createOderItems(Integer orderId, List<OrderItem> orderItemList) {

        String sql = "INSERT INTO Order_item (order_id, product_id, quantity, amount)" +
                        "values (:order_id, :product_id, :quantity, :amount)";

        MapSqlParameterSource[] mapSqlParameterSources = new MapSqlParameterSource[orderItemList.size()];

        for(int i=0; i<orderItemList.size(); i++){
            OrderItem tmpOrderItem = orderItemList.get(i);
            mapSqlParameterSources[i] = new MapSqlParameterSource();
            mapSqlParameterSources[i].addValue("order_id",orderId);
            mapSqlParameterSources[i].addValue("product_id",tmpOrderItem.getProduct_id());
            mapSqlParameterSources[i].addValue("quantity",tmpOrderItem.getQuantity());
            mapSqlParameterSources[i].addValue("amount",tmpOrderItem.getAmount());

        }

        namedParameterJdbcTemplate.batchUpdate(sql,mapSqlParameterSources);
    }

    @Override
    public OrderDetails getOrderById(Integer orderId) {

        String sql = "SELECT order_id, user_id, total_amount, created_date, last_modified_date FROM Order_details " +
                        "WHERE order_id = :order_id";

        HashMap<String,Object> map = new HashMap<>();
        map.put("order_id",orderId);

        List<OrderDetails> orderDetailsList =  namedParameterJdbcTemplate.query(sql,map, new OrderDetailsRowMapper());

        if(orderDetailsList.size()>0){
            return orderDetailsList.get(0);
        }

        return null;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
        String sql = "SELECT Oi.order_item_id, Oi.order_id, Oi.product_id, Oi.quantity, Oi.amount, pd.product_name, pd.image_url " +
                        "FROM Order_item Oi " +
                        "LEFT JOIN Product pd on Oi.product_id = pd.product_id "  +
                        "WHERE Oi.order_id  = :order_id ";

        Map<String ,Object> map = new HashMap<>();
        map.put("order_id",orderId);

        List<OrderItem> orderItemList = namedParameterJdbcTemplate.query(sql,map ,new OrderItemRowMapper());

        return orderItemList;
    }
}
