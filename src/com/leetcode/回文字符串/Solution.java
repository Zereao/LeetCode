package com.leetcode.回文字符串;

import com.leetcode.common.Utils;

/**
 * @author Zereao
 * @version 2020/4/29 15:40
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(s.isPalindrome(str));
    }

    public boolean isPalindrome(String s) {
        if (Utils.isEmpty(s)) {
            return true;
        }
        String realStr = s.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(realStr);
        return realStr.equalsIgnoreCase(sb.reverse().toString());
    }
}
