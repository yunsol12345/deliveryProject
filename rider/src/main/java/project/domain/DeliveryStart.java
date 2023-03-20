package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class DeliveryStart extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;
    private String status;

    public DeliveryStart(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryStart() {
        super();
    }
}
