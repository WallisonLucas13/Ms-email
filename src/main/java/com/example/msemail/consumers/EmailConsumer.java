package com.example.msemail.consumers;

import com.example.msemail.dtos.MailDto;
import com.example.msemail.services.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload MailDto dto){
        mailService.save(dto);
    }
}
