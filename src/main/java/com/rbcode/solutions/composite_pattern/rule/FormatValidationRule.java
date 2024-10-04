package com.rbcode.solutions.composite_pattern.rule;

import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class FormatValidationRule implements Rule {
    private static final String FORMAT = "\\d{10}";

    private final String value;

    @Override
    public boolean isSatisfied() {
        Pattern pattern = Pattern.compile(FORMAT);
        Matcher matcher = pattern.matcher(value);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches > 0;
    }
}
