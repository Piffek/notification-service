package org.shelter.notificationservice.messagebroker.receivers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class NotificationReceiver {

    @RabbitListener(queues = "${notification.queue.name}")
    public void receiveNotification(String notification) {
        log.info("recieved notification {} ...", notification);
    }
}
