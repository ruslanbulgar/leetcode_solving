package com.rbcode.leatcode._42_trapping_rain_water;

public class Solution {
    public int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process the left side
                if (height[left] >= leftMax) {
                    // Update leftMax to current height as it's the highest so far
                    leftMax = height[left];
                } else {
                    // Calculate trapped water at the current left position
                    totalWater += leftMax - height[left];
                }
                left++; // Move left pointer inward
            } else {
                // Process the right side
                if (height[right] >= rightMax) {
                    // Update rightMax to current height as it's the highest so far
                    rightMax = height[right];
                } else {
                    // Calculate trapped water at the current right position
                    totalWater += rightMax - height[right];
                }
                right--; // Move right pointer inward
            }
        }

        return totalWater;
    }

    public int trap2(int[] height) {
        int totalWater = 0;
        if (height == null || height.length < 3) {
            return totalWater;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().trap2(new int[]{1,2,3,2,1}));
    }
}
