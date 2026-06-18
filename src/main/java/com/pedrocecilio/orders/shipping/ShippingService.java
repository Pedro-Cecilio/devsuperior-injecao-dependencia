package com.pedrocecilio.orders.shipping;

import com.pedrocecilio.orders.order.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ShippingService {

    private static final BigDecimal REDUCED_SHIPPING_MIN_VALUE = new BigDecimal("100.00");
    private static final BigDecimal FREE_SHIPPING_MIN_VALUE = new BigDecimal("200.00");

    private static final BigDecimal FULL_SHIPPING_VALUE = new BigDecimal("20.00");
    private static final BigDecimal REDUCED_SHIPPING_VALUE = new BigDecimal("12.00");
    private static final BigDecimal FREE_SHIPPING_VALUE = BigDecimal.ZERO;

    public BigDecimal shipment(Order order) {
        BigDecimal basic = order.getBasic();

        if (basic.compareTo(REDUCED_SHIPPING_MIN_VALUE) < 0) {
            return FULL_SHIPPING_VALUE;
        }

        if (basic.compareTo(FREE_SHIPPING_MIN_VALUE) < 0 ) {
            return REDUCED_SHIPPING_VALUE;
        }

        return FREE_SHIPPING_VALUE;
    }
}
