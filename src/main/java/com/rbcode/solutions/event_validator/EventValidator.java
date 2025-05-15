package com.rbcode.solutions.event_validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EventValidator {

    @Autowired
    private Map<String, Validator> validators;

    void validate(Event event) {
        System.out.println(validators);

    }

    public static void main(String[] args) {
        new EventValidator().validate(null);
    }
}
