package com.lefnds.practicingtests.storeV2;

import com.lefnds.practicingtests.storeV2.order.Order;
import com.lefnds.practicingtests.storeV2.order.OrderService;
import com.lefnds.practicingtests.storeV2.payment.PaymentService;
import com.lefnds.practicingtests.storeV2.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class OrderServiceV2Test {

    @Mock
    private UserService userService;
    @Mock
    private PaymentService paymentService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks( this );

        orderService = new OrderService( userService, paymentService, true );

    }

    @Test
    @DisplayName( "Deve lançar uma exceção se o usuario for menor de idade" )
    public void ShouldThrowsAnExceptionWhenUserIsMinor() {

        Order order = new Order( "1" );

        Mockito.when(userService.isMinor( "1" )).thenReturn( true );
        Mockito.doNothing().when(paymentService).pay();

        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> orderService.create(order));

        Assertions.assertEquals( "Minor user not allowed" , ex.getMessage() );

        Mockito.verify(userService, Mockito.times( 1 )).isMinor( "1" );
        Mockito.verify(paymentService, Mockito.times( 0 )).pay();

    }

    @Test
    @DisplayName( "Deve prosseguir para o pagamento se o usuario for maior de idade" )
    public void ShouldPayWhenUserIsMajor() {

        orderService = new OrderService( userService, paymentService, false );

        Order order = new Order( "2" );

        Mockito.when(userService.isMinor( "2" )).thenReturn( false );
        Mockito.doNothing().when(paymentService).pay();

        orderService.create(order);

        Mockito.verify(userService, Mockito.times( 1 )).isMinor( "2" );
        Mockito.verify(paymentService, Mockito.times( 1 )).pay();

    }
}
