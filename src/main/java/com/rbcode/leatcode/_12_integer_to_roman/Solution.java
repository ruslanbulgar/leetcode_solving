package com.rbcode.leatcode._12_integer_to_roman;

import java.util.Collections;

public class Solution {

    public String intToRoman(int num) {
        if (num > 0 && num < 4000) {
            return convert(num);
        }
        return "";
    }

    private String convert(int num) {
        StringBuilder response = new StringBuilder();

        num = convertThousends(response, num);
        num = convert(response, num, 100, "C", "CD", "D", "CM");
        num = convert(response, num, 10, "X", "XL", "L", "XC");
        convert(response, num, 1, "I", "IV", "V", "IX");

        return response.toString();
    }

    private int convertThousends(StringBuilder response, int number) {
        if (number >= 1000) {
            response.append(String.join("", Collections.nCopies(number / 1000, "M")));
            return number % 1000;
        }

        return number;
    }

    private int convert(StringBuilder response, int number, int root, String units, String forth, String fith, String ninth) {

        if (number >= root) {
            int n = number / root;
            if (n < 4) {
                response.append(String.join("", Collections.nCopies(n, units)));
            } else if (n == 4) {
                response.append(forth);
            } else if (n < 9) {
                response.append(fith).append(String.join("", Collections.nCopies(n - 5, units)));
            } else if (n == 9) {
                response.append(ninth);
            }
            return number % root;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1994));
    }
}
