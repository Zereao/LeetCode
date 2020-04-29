package com.leetcode.数组_最长连续序列长;

import com.leetcode.common.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zereao
 * @version 2020/4/29 13:48
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = Utils.buildArray(0, -1);
        int r = s.longestConsecutive(num);
        System.out.println(r);
    }

    public int longestConsecutive(int[] num) {
        if (num == null || num.length <= 0) {
            return 0;
        }
        List<Integer> numList = Arrays.stream(num).distinct().sorted().boxed().collect(Collectors.toList());
        int maxLen = 1;
        int tempLen = 1;
        for (int i = 1, len = numList.size(); i < len; i++) {
            if (numList.get(i) - numList.get(i - 1) == 1) {
                ++tempLen;
                maxLen = Math.max(tempLen, maxLen);
            } else {
                maxLen = Math.max(tempLen, maxLen);
                tempLen = 1;
            }
        }
        return maxLen;
    }
}
