package com.rbcode.leatcode.java17_features;

import com.rbcode.leatcode.java17_features.records.Product;
import nonapi.io.github.classgraph.json.JSONDeserializer;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import java.util.Objects;

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
