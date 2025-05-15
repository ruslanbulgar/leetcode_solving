package com.rbcode.solutions.rule_engine;

import com.rbcode.solutions.rule_engine.model.Message;
import com.rbcode.solutions.rule_engine.model.Person;
import com.rbcode.solutions.rule_engine.processors.CSIMessageService;
import com.rbcode.solutions.rule_engine.processors.MessageService;
import com.rbcode.solutions.rule_engine.processors.Region1MessageService;
import com.rbcode.solutions.rule_engine.services.CSIMessageProcessor;
import com.rbcode.solutions.rule_engine.services.MDDMessageProcessor;

import java.util.List;

import static java.util.Objects.isNull;

public class MessageSender {

    private static List<MessageService> messageServices = List.of(
            new Region1MessageService(new MDDMessageProcessor()),
            new CSIMessageService(new CSIMessageProcessor())
    );

    public static void send(Message message, List<Person> receivers) {

        receivers.forEach(r-> {
            final MessageService messageService = messageServices
                    .stream()
                    .filter(m -> m.validate(r.getCountry()))
                    .findFirst()
                    .orElse(null);

            if(isNull(messageService)) {
                System.out.println("Could not find a message service for country : " + r.getCountry());
            } else {
                boolean isSent = messageService.send(message, r);
                System.out.println("is Messaage sent : " + isSent);
            }
        });
    }
}
