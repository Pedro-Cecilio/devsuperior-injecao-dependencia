package com.pedrocecilio.orders.order;

import java.math.BigDecimal;

public class Order {
    private final Integer code;
    private final BigDecimal basic;
    private final BigDecimal discount;

    public Order(Integer code, BigDecimal basic, BigDecimal discount){
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode(){
        return this.code;
    }

    public BigDecimal getBasic(){
        return this.basic;
    }
    public BigDecimal getDiscount(){
        return this.discount;
    }
}
