package com.rbcode.leatcode._13_roman_to_integer;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static Map<Character, Integer> SYMBOL_MAPPING = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        if(s.matches("^[IVXLCDM]{1,15}$")) {
            return convert(s);
        }
        return 0;
    }

    private int convert(String romanNumber) {
        List<Integer> numbers
                = romanNumber.codePoints().mapToObj(c -> SYMBOL_MAPPING.get((char) c)).collect(Collectors.toList());

        Integer response = 0;
        for(int i = numbers.size()- 1; i>= 0; i--) {
            if(i-1 >= 0 && numbers.get(i) > numbers.get(i-1)) {
                response += numbers.get(i) - numbers.get(i-1);
                i = i-1;
            } else {
                response+=numbers.get(i);
            }
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
