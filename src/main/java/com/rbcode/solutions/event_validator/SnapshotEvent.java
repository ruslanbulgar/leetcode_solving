package com.rbcode.solutions.event_validator;

public class SnapshotEvent extends Event {
    @Override
    public void printName() {
        System.out.println("Snapshot event");
    }
}
