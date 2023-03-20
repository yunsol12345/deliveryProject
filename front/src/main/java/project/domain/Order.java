package project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import project.FrontApplication;
import project.domain.OrderCanceled;
import project.domain.OrderPlaced;
import project.domain.Paid;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long storeId;

    private Long foodId;

    private String customerId;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void paid(PaymentPaid paymentPaid) {
           repository().findById(paymentPaid.getOrderId()).ifPresent(order->{
            order.setStatus("PAID");
            repository().save(order);

            OrderPaid orderPaid = new OrderPaid(order);
            orderPaid.publishAfterCommit();

    }
}
