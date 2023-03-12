package com.rbcode.leatcode.rule_engine;

import com.rbcode.leatcode.rule_engine.model.Country;
import com.rbcode.leatcode.rule_engine.model.Message;
import com.rbcode.leatcode.rule_engine.model.Person;

import java.util.List;

import static com.rbcode.leatcode.rule_engine.model.Country.MOLDOVA;
import static com.rbcode.leatcode.rule_engine.model.Country.RUSSIA;

public class Main {
    public static void main(String[] args) {

        Message message = createMessage();
        List<Person> receivers = createReceivers();

        MessageSender.send(message, receivers);

    }

    private static List<Person> createReceivers() {
        return List.of(createReceiver("R1", MOLDOVA, "+37354545450"),
                createReceiver("R2", RUSSIA, "+73545454522"));
    }

    private static Person createReceiver(String name, Country country, String phoneNumber) {
        Person person = new Person();
        person.setName(name);
        person.setCountry(country);
        person.setPhoneNumber(phoneNumber);
        return person;
    }

    private static Message createMessage() {
        Message message = new Message();
        message.setSubject("Important Message");
        message.setText("Hi, this message is very important and you should receive it as soon as possible!");
        return message;
    }
}
