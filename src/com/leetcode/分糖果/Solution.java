package com.leetcode.分糖果;

import java.util.Arrays;

/**
 * @author Zereao
 * @version 2020/4/20 20:18
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = {1, 3, 5};
        System.out.println(s.candy(r));
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length <= 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        int minCount = 0;
        for (int candy : candies) {
            minCount += candy;
        }
        return minCount;
    }
}
