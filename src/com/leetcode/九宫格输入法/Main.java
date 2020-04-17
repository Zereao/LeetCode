package com.leetcode.九宫格输入法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zereao
 * @version 2020/4/6 14:36
 */
public class Main {

    private String numberPad(String insert) {
        StringBuilder result = new StringBuilder();
        String[] nums = {"0 ", "1,.?!", "2ABC", "3DEF", "4GHI", "5JKL", "6MNO", "7PQRS", "8TUV", "9WXYZ"};
        String[] inStr = insert.split(" ");
        for (String str : inStr) {
            int index = Integer.parseInt(str.substring(0, 1));
            String realStr = nums[index];
            int secondIndex = str.length() - 1;
            char realAlpha = realStr.charAt(secondIndex);
            result.append(realAlpha);
        }
        return result.toString();
    }

    private List<String> anotherNumberPad(String insertStr) {
        String[] nums = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> resultList = new ArrayList<>();
        if (insertStr.length() == 1) {
            int index = Integer.parseInt(insertStr);
            for (char thrChar : nums[index].toCharArray()) {
                resultList.add(String.valueOf(thrChar));
            }
            return resultList;
        }
        int index = Integer.parseInt(String.valueOf(insertStr.charAt(0)));
        for (char aChar : nums[index].toCharArray()) {
            List<String> childList = this.anotherNumberPad(insertStr.substring(1));
            for (String childResult : childList) {
                String result = aChar + childResult;
                resultList.add(result);
            }
        }
        return resultList;
    }

    private String[] a = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {
        Main a = new Main();
//        String result = a.numberPad("22 5555 22 666 00 88 888 7777 4444 666 44");
        List<String> result = a.anotherNumberPad("233");
        System.out.println(result.toString());
    }
}
