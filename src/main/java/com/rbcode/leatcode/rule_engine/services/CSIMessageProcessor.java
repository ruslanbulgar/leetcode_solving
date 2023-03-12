package com.rbcode.leatcode.rule_engine.services;

import com.rbcode.leatcode.rule_engine.model.Message;

public class CSIMessageProcessor implements MessageProcessor {
    @Override
    public boolean validateNumber(String phoneNumber) {
        return phoneNumber.length() == 12 && phoneNumber.startsWith("+7");
    }

    @Override
    public boolean processAndSend(Message message) {
        System.out.println("Sending message via CSI message processor...");
        //do the sending

        System.out.println("Message sent");
        return true;
    }
}
