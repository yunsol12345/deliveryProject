package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private Long storeId;
    private Long foodId;
    private Long customerId;
    private String address;
    private String status;
}
