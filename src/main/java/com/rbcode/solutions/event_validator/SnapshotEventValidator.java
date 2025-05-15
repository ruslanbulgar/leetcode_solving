package com.rbcode.solutions.event_validator;

public class SnapshotEventValidator implements Validator {
    @Override
    public void validate(Event event) {
        event.printName();
    }
}
