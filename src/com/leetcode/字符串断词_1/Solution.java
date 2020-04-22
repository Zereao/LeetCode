package com.leetcode.字符串断词_1;

import com.leetcode.common.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zereao
 * @version 2020/4/20 19:26
 */
class Solution {
    public static void main(String[] args) {
        String str = "leetcode";
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        Solution s = new Solution();
        boolean re = s.wordBreak(str, dict);
        System.out.println(re);
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (Utils.isEmpty(s) || Utils.isEmpty(dict)) {
            return false;
        }
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; --j) {
                String word = s.substring(j, i);
                if (flag[j] && dict.contains(word)) {
                    flag[i] = true;
                    break;
                } else {
                    flag[i] = false;
                }
            }
        }
        return flag[s.length()];

    }
}
