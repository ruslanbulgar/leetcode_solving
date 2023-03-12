package com.rbcode.leatcode.rule_engine.model;

import java.util.Objects;

public class Message {

    private String subject;

    private String text;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(subject, message.subject) && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, text);
    }
}
