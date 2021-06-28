package com.baizhi.proxy.service.proxy;

import com.baizhi.proxy.service.Impl.OrderServiceImpl;
import com.baizhi.proxy.service.OrderService;

public class OrderServiceProxy implements OrderService {

    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("---log---showOrder---");
        orderService.showOrder();
    }
}
