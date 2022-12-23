package com.lefnds.practicingtests.storeV2.order;

import com.lefnds.practicingtests.storeV2.payment.PaymentService;
import com.lefnds.practicingtests.storeV2.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private UserService userService;
    private PaymentService paymentService;
    private Boolean flag;

    public OrderService(UserService userService,
                        PaymentService paymentService,
                        @Value("${flag}") Boolean flag) {
        this.userService = userService;
        this.paymentService = paymentService;
        this.flag = flag;
    }

    public void create( Order order ) {
        boolean isMinor = userService.isMinor( order.getUserId() );

        if( flag || isMinor ) {
            throw new IllegalStateException("Minor user not allowed");
        }

        paymentService.pay();
    }
}
