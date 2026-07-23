package com.hkwprince.springbootonlineshop.dto;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class CreateOrderRequest {

    @NotEmpty
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
