package com.rbcode.solutions.java_features;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

public class TextBlock {
    private static final String json = """
            {
                "id": 1,
                "name": "Cup",
                "description": "Cup description",
                "price": 10.4,
                "quantity": 100
            }
            """;

    public static void main(String[] args) throws ParseException {
        System.out.println(json);

        Object jsonObject = new JSONParser(json).parse();

        System.out.println(jsonObject);
    }
}
