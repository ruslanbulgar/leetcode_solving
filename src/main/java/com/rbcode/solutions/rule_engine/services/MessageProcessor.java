package com.rbcode.solutions.rule_engine.services;

import com.rbcode.solutions.rule_engine.model.Message;
import com.rbcode.solutions.rule_engine.model.Person;

public interface MessageProcessor {
    boolean validateNumber(String phoneNumber);

    boolean processAndSend(Message message, Person person);
}
