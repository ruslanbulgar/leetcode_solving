package com.rbcode.leatcode._11_container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {

        if(height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int maxArea = 0;

        while (left < right) {
            if (height[left] > height[right]) {
                maxLeft = height[left];
                right--;
            } else {
                maxRight = height[right];
                left++;
            }
            int tmpMin = Math.min(maxLeft, maxRight);
            int tmpArea = tmpMin > 0 ? tmpMin * (right - left + 1) : 0;
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,2,4,3}));
    }
}
