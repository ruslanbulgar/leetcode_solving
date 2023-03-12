package com.rbcode.leatcode.rule_engine.processors;

import com.rbcode.leatcode.rule_engine.model.Country;
import com.rbcode.leatcode.rule_engine.services.MDDMessageProcessor;
import com.rbcode.leatcode.rule_engine.services.MessageProcessor;

import java.util.Objects;

public class Region1MessageService implements MessageService {

    private final MDDMessageProcessor messageProcessor;

    public Region1MessageService(MDDMessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Override
    public MessageProcessor getMessageProcessor() {
        return messageProcessor;
    }

    @Override
    public boolean validate(final Country country) {
        return Objects.equals(Country.MOLDOVA, country);
    }
}
