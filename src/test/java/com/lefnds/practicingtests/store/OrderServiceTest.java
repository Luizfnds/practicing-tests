//package com.lefnds.practicingtests.store;
//
//import com.lefnds.practicingtests.store.order.Order;
//import com.lefnds.practicingtests.store.order.OrderService;
//import com.lefnds.practicingtests.store.payment.PaymentService;
//import com.lefnds.practicingtests.store.user.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class OrderServiceTest {
//
//    @Test
//    public void ThrowsAnExceptionWhenUserIsMinor() {
//        UserService userService = new UserService();
//        PaymentService paymentService = new PaymentService();
//        OrderService orderService = new OrderService(userService, paymentService);
//
//        Order order = new Order("1");
//
//        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> orderService.create(order));
//
//        Assertions.assertEquals("Minor user not allowed", ex.getMessage());
//    }
//}
