package com.rbcode.leatcode.rule_engine.processors;

import com.rbcode.leatcode.rule_engine.model.Country;
import com.rbcode.leatcode.rule_engine.services.CSIMessageProcessor;
import com.rbcode.leatcode.rule_engine.services.MessageProcessor;

import java.util.Arrays;

import static com.rbcode.leatcode.rule_engine.model.Country.RUSSIA;
import static com.rbcode.leatcode.rule_engine.model.Country.UKRAINE;

public class CSIMessageService implements MessageService {

    private final CSIMessageProcessor csiMessageProcessor;

    public CSIMessageService(CSIMessageProcessor csiMessageProcessor) {
        this.csiMessageProcessor = csiMessageProcessor;
    }

    @Override
    public MessageProcessor getMessageProcessor() {
        return csiMessageProcessor;
    }

    @Override
    public boolean validate(Country country) {
        return Arrays.asList(RUSSIA, UKRAINE).contains(country);
    }
}
