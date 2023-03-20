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

    private String oderId;

    private String storeId;

    private String foodId;

    private String customerId;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

        CookingAccepted cookingAccepted = new CookingAccepted(this);
        cookingAccepted.publishAfterCommit();

        CookingRejected cookingRejected = new CookingRejected(this);
        cookingRejected.publishAfterCommit();

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public static void cancel(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }

    public static void add(Paid paid) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}
