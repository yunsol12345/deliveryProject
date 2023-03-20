package project.domain;

import java.util.*;
import lombok.*;
import project.domain.*;
import project.infra.AbstractEvent;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private String oderId;
    private String storeId;
    private String foodId;
    private String customerId;
    private String status;
    private String address;
}
