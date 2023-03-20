package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private Long oderId;
    private Long storeId;
    private Long foodId;
    private String customerId;
    private String status;
    private String address;
}
