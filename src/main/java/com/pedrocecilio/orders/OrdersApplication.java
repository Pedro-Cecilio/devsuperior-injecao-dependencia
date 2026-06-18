package com.pedrocecilio.orders;

import com.pedrocecilio.orders.order.Order;
import com.pedrocecilio.orders.order.OrderService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@SpringBootApplication
public class OrdersApplication implements ApplicationRunner {

    private final OrderService orderService;

    public OrdersApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        List<String> codeArgs = args.getOptionValues("code");
        List<String> basicArgs = args.getOptionValues("basic");
        List<String> discountArgs = args.getOptionValues("discount");

        if (codeArgs == null || codeArgs.isEmpty() || codeArgs.getFirst().isBlank()) {
            System.out.println("Código do pedido não informado");
            return;
        }

        if (basicArgs == null || basicArgs.isEmpty() || basicArgs.getFirst().isBlank()) {
            System.out.println("Valor do pedido não informado");
            return;
        }

        if (discountArgs == null || discountArgs.isEmpty() || discountArgs.getFirst().isBlank()) {
            System.out.println("Desconto do pedido não informado");
            return;
        }

        try {
            Integer code = Integer.parseInt(codeArgs.getFirst());
            BigDecimal basic = new BigDecimal(basicArgs.getFirst());
            BigDecimal discount = new BigDecimal(discountArgs.getFirst());

            Order order = new Order(code, basic, discount);

            BigDecimal totalValue = orderService.total(order)
                    .setScale(2, RoundingMode.HALF_UP);

            System.out.printf("Pedido código %d%n", order.getCode());
            System.out.println("Valor total: R$" + totalValue);

        } catch (NumberFormatException exception) {
            System.out.println("Argumentos inválidos. Use números válidos.");
        }
    }
}