package com.rbcode.leatcode._41_first_missing_positive;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int firstMissingPositive(int[] nums) {

        int positive = 1;

        List<Integer> numsList = Arrays.stream(nums).boxed().toList();

        while (positive <= nums.length) {
            if (!numsList.contains(positive)) {
                return positive;
            }
            positive++;
        }
        return positive;
    }

    public static void main(String[] args) {
       int result = new Solution().firstMissingPositive(new int[]{7,8,9,11,12});
        System.out.println(result);
    }
}
