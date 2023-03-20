package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String storeId;
    private String foodId;
    private String customerId;
    private String address;
    private String status;
}
