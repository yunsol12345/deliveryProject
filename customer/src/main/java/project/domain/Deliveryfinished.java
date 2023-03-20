package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class Deliveryfinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;
    private String status;
}
