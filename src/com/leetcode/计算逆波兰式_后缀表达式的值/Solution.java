package com.leetcode.计算逆波兰式_后缀表达式的值;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * @author Zereao
 * @version 2020/4/16 16:16
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = new String[]{"3", "-4", "+"};
        int res = s.evalRPN(a);
        System.out.println(res);
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    this.calculateAndPush(stack, token, Integer::sum);
                    break;
                case "-":
                    this.calculateAndPush(stack, token, (v1, v2) -> v1 - v2);
                    break;
                case "*":
                    this.calculateAndPush(stack, token, (v1, v2) -> v1 * v2);
                    break;
                case "/":
                    this.calculateAndPush(stack, token, (v1, v2) -> v1 / v2);
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    private void calculateAndPush(Stack<String> stack, String token, BiFunction<Integer, Integer, Integer> f) {
        // 注意 token1、token2的顺序，2-1 和 1-2 不一样
        Integer token2 = Integer.valueOf(stack.pop());
        Integer token1 = Integer.valueOf(stack.pop());
        Integer result = f.apply(token1, token2);
        stack.push(String.valueOf(result));
    }
}
