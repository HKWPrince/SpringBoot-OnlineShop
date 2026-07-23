package com.hkwprince.springbootonlineshop.model;

public class OrderItem {

    private Integer oder_item_id;
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;
    private Integer amount;

    private String product_name;
    private String image_url;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getOder_item_id() {
        return oder_item_id;
    }

    public void setOder_item_id(Integer oder_item_id) {
        this.oder_item_id = oder_item_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
