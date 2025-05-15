package com.rbcode.solutions.rule_engine.services;

import com.rbcode.solutions.rule_engine.model.Message;
import com.rbcode.solutions.rule_engine.model.Person;

public class MDDMessageProcessor implements MessageProcessor {
    @Override
    public boolean validateNumber(String phoneNumber) {
        return phoneNumber.length() == 12 && phoneNumber.startsWith("+373");
    }

    @Override
    public boolean processAndSend(Message message, Person person) {
        System.out.println("Sending message via MDD message processor...");
        //do the sending
        System.out.println("Sending message to " + person.getPhoneNumber());
        System.out.println("Message sent");
        return true;
    }
}
