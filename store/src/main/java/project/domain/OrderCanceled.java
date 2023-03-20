package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Long oderId;
    private Long storeId;
    private Long foodId;
    private Long customerId;
    private String status;
    private String address;

    public OrderCanceled(Cooking aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}
