package com.rbcode.leatcode._868_binary_gap;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int binaryGap(int n) {
        // Convert the number to binary and get positions of '1's
        int lastPosition = -1;  // to track the last position of '1'
        int maxDistance = 0;    // to track the maximum distance
        int currentPosition = 0; // current position of bits

        // Loop through the bits of the number
        while (n > 0) {
            // Check if the least significant bit is '1'
            if ((n & 1) == 1) {
                // If this is not the first '1', calculate the distance
                if (lastPosition != -1) {
                    maxDistance = Math.max(maxDistance, currentPosition - lastPosition);
                }
                // Update lastPosition to the current position
                lastPosition = currentPosition;
            }
            // Right shift the bits of the number
            n >>= 1;
            // Increment the bit position
            currentPosition++;
        }

        // Return the maximum distance found
        return maxDistance;
    }

    public int binaryGap2(int n) {
        System.out.println(Integer.toBinaryString(n));
        char[] binChars = Integer.toBinaryString(n).toCharArray();

        List<Integer> onePos = new ArrayList<>();

        for (int i = 0; i < binChars.length; i++) {
            if(binChars[i] == '1') {
                onePos.add(i);
            }
        }
        if(onePos.size() <= 1) {
            return 0;
        }

        int maxGap = 0;
        for (int i = 0; i < onePos.size()-1; i++) {
            maxGap = Math.max(maxGap, onePos.get(i+1) - onePos.get(i));
        }

        return maxGap;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().binaryGap(1000));
        System.out.println(new Solution().binaryGap2(1000));

    }
}
