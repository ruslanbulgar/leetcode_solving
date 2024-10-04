package com.rbcode.solutions.composite_pattern.rule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidationRule implements Rule {
    private static final SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");

    private String value;

    public DateValidationRule(String value) {
        this.value = value;
    }

    @Override
    public boolean isSatisfied() {
        try {
            Date javaDate = sdfrmt.parse(value);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
