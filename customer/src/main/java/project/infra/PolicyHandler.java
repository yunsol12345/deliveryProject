package project.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import project.config.kafka.KafkaProcessor;
import project.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_Notify(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener Notify : " + orderCanceled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingAccepted'"
    )
    public void wheneverCookingAccepted_Notify(
        @Payload CookingAccepted cookingAccepted
    ) {
        CookingAccepted event = cookingAccepted;
        System.out.println(
            "\n\n##### listener Notify : " + cookingAccepted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingRejected'"
    )
    public void wheneverCookingRejected_Notify(
        @Payload CookingRejected cookingRejected
    ) {
        CookingRejected event = cookingRejected;
        System.out.println(
            "\n\n##### listener Notify : " + cookingRejected + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingStarted'"
    )
    public void wheneverCookingStarted_Notify(
        @Payload CookingStarted cookingStarted
    ) {
        CookingStarted event = cookingStarted;
        System.out.println(
            "\n\n##### listener Notify : " + cookingStarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingFinished'"
    )
    public void wheneverCookingFinished_Notify(
        @Payload CookingFinished cookingFinished
    ) {
        CookingFinished event = cookingFinished;
        System.out.println(
            "\n\n##### listener Notify : " + cookingFinished + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStart'"
    )
    public void wheneverDeliveryStart_Notify(
        @Payload DeliveryStart deliveryStart
    ) {
        DeliveryStart event = deliveryStart;
        System.out.println(
            "\n\n##### listener Notify : " + deliveryStart + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliveryfinished'"
    )
    public void wheneverDeliveryfinished_Notify(
        @Payload Deliveryfinished deliveryfinished
    ) {
        Deliveryfinished event = deliveryfinished;
        System.out.println(
            "\n\n##### listener Notify : " + deliveryfinished + "\n\n"
        );
        // Sample Logic //

    }
}
