package com.rbcode.leatcode.rule_engine.services;

import com.rbcode.leatcode.rule_engine.model.Message;
import com.rbcode.leatcode.rule_engine.model.Person;

public interface MessageProcessor {
    boolean validateNumber(String phoneNumber);

    boolean processAndSend(Message message, Person person);
}
