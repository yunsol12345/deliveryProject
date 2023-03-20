package project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import project.StoreApplication;
import project.domain.CookingAccepted;
import project.domain.CookingFinished;
import project.domain.CookingRejected;
import project.domain.CookingStarted;
import project.domain.OrderCanceled;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long storeId;

    private Long foodId;

    private String customerId;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void accept() {
        setStatus("ACCEPTED");
        CookingAccepted cookingAccepted = new CookingAccepted(this);
        cookingAccepted.publishAfterCommit();
    }

    public void start() {
        setStatus("STARTED");
        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();
    }

    public void finish() {
        setStatus("FINISHED");
        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();
    }

    public void reject() {
        setStatus("REJECETED");
        CookingRejected cookingRejected = new CookingRejected(this);
        cookingRejected.publishAfterCommit();
    }

    public static void add(OrderPaid orderPaid) {
        Cooking cooking = new Cooking();
        cooking.setOrderId(orderPaid.getId());
        cooking.setStoreId(orderPaid.getStoreId());
        cooking.setFoodId(orderPaid.getFoodId());
        cooking.setCustomerId(orderPaid.getCustomerId());
        cooking.setAddress(orderPaid.getAddress());
        cooking.setStatus("READY");
        repository().save(cooking);
    }

    public static void cancel(CancelRequested cancelRequested) {
        repository().findByOrderId(cancelRequested.getId()).ifPresent(cooking->{
            if (cooking.getStatus().equals("READY") || cooking.getStatus().equals("ACCEPTED")) {
                cooking.setStatus("CANCELED");
                repository().save(cooking);

                OrderCanceled orderCanceled = new OrderCanceled(cooking);
                orderCanceled.publishAfterCommit();
            }
         });
    }
}