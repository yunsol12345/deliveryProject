package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class PaymentPaid extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
}
