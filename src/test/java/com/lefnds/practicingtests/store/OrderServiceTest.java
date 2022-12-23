package com.lefnds.practicingtests.store;

import com.lefnds.practicingtests.store.order.Order;
import com.lefnds.practicingtests.store.order.OrderService;
import com.lefnds.practicingtests.store.payment.PaymentService;
import com.lefnds.practicingtests.store.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderServiceTest {

    UserService userService = Mockito.mock(UserService.class);
    PaymentService paymentService = Mockito.mock(PaymentService.class);
    OrderService orderService = new OrderService(userService, paymentService);

    @Test
    public void ThrowsAnExceptionWhenUserIsMinor() {

        Order order = new Order("1");

        Mockito.when(userService.isMinor("1")).thenReturn(true);
        Mockito.doNothing().when(paymentService).pay();

        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> orderService.create(order));

        Assertions.assertEquals("Minor user not allowed", ex.getMessage());

        Mockito.verify(userService, Mockito.times(1)).isMinor("1");
        Mockito.verify(paymentService, Mockito.times(0)).pay();

    }

    @Test
    public void PayWhenUserIsMajor() {

        Order order = new Order("2");

        Mockito.when(userService.isMinor("2")).thenReturn(false);
        Mockito.doNothing().when(paymentService).pay();

        orderService.create(order);

        Mockito.verify(userService, Mockito.times(1)).isMinor("2");
        Mockito.verify(paymentService, Mockito.times(1)).pay();

    }
}
