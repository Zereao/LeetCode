package com.leetcode.加油站;

/**
 * @author Zereao
 * @version 2020/4/20 20:57
 */
class Solution {
    public static void main(String[] args) {
        int[] gas = {1, 2};
        int[] cost = {2, 1};
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length <= 0) {
            return -1;
        }
        int i = 0, n = gas.length;
        while (i < n) {
            int totalGas = 0;
            int tmp = 0;
            boolean flag = true;
            // 确保每次最多走N步
            while (tmp < n) {
                /* 核心步骤，tmp 代表 出发后，走了多少步
                 * 假如 n = 6，从 3 出发，那走了 5步 的时候，下标走到了 3+5 = 8
                 * 实际上应该映射到 (3+5)%6 = 2 */
                int index = (i + tmp) % n;
                totalGas = totalGas + gas[index] - cost[index];
                if (totalGas < 0) {
                    flag = false;
                    break;
                }
                ++tmp;
            }
            if (flag) {
                return i;
            }
            ++i;
        }
        return -1;
    }
}
