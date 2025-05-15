package com.rbcode.solutions.rule_engine.processors;

import com.rbcode.solutions.rule_engine.model.Country;
import com.rbcode.solutions.rule_engine.model.Message;
import com.rbcode.solutions.rule_engine.model.Person;
import com.rbcode.solutions.rule_engine.services.MessageProcessor;

public interface MessageService {

    MessageProcessor getMessageProcessor();

    boolean validate(Country country);

    default boolean send(Message message, Person person) {
        MessageProcessor messageProcessor = getMessageProcessor();

        if(!messageProcessor.validateNumber(person.getPhoneNumber())) {
            System.out.println("Invalid number format " + person.getPhoneNumber());
            return false;
        }

        return messageProcessor.processAndSend(message, person);
    }
}
