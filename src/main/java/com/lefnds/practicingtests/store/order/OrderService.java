package com.lefnds.practicingtests.store.order;

import com.lefnds.practicingtests.store.payment.PaymentService;
import com.lefnds.practicingtests.store.user.UserService;

public class OrderService {

    private UserService userService;
    private PaymentService paymentService;

    public OrderService( UserService userService, PaymentService paymentService ) {
        this.userService = userService;
        this.paymentService = paymentService;
    }

    public void create( Order order ) {
        boolean isMinor = userService.isMinor( order.getUserId() );

        if( isMinor ) {
            throw new IllegalStateException("Minor user not allowed");
        }

        paymentService.pay();
    }
}
