package project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import project.RiderApplication;
import project.domain.DeliveryStart;
import project.domain.Deliveryfinished;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliveryStart deliveryStart = new DeliveryStart(this);
        deliveryStart.publishAfterCommit();

        Deliveryfinished deliveryfinished = new Deliveryfinished(this);
        deliveryfinished.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void addDelivery(CookingFinished cookingFinished) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}
