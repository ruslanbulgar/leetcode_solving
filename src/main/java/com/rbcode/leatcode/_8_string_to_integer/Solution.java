package com.rbcode.leatcode._8_string_to_integer;

public class Solution {
    public int myAtoi(String s) {

        int number = 0;
        boolean firstChar = false;
        char sign = ' ';

        s = s.trim();

        for (char c : s.toCharArray()) {
            if (number == 0 && !firstChar) {
                if (c >= '0' && c <= '9') {
                    number = toInt(c, sign);
                    firstChar = true;
                } else {
                    if (c == '-') {
                        sign = '-';
                    } else {
                        firstChar = true;
                    }
                }
            } else {
                if (c >= '0' && c <= '9') {
                    number *= 10 + toInt(c, sign);

                    if (number < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }

                    if (number > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    break;
                }
            }
        }

        return number;
    }

    private int toInt(char c, char sign) {
        return Character.getNumericValue(c) * (sign == '-' ? -1 : 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("91283472332"));
    }
}
