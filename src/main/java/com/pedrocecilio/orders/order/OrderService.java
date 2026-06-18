package com.pedrocecilio.orders.order;

import com.pedrocecilio.orders.shipping.ShippingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OrderService {
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public BigDecimal total(Order order) {
        BigDecimal shipment = this.shippingService.shipment(order);
        BigDecimal discountValue = order
                .getBasic()
                .multiply(order.getDiscount().divide(ONE_HUNDRED, 4, RoundingMode.HALF_UP));
        return order.getBasic().subtract(discountValue).add(shipment);
    }
}
