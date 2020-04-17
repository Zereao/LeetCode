package com.leetcode.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zereao
 * @version 2020/4/6 16:14
 */
public class Main {

    public static void main(String[] args) {
        Main a = new Main();
        List<String> resultList = a.totalSort("123");
        System.out.println(resultList);
    }

    private List<String> totalSort(String alpha) {
        List<String> resultList = new ArrayList<>();

        if (alpha.length() == 1) {
            resultList.add(alpha);
            return resultList;
        }
        for (char c : alpha.toCharArray()) {
            String cStr = String.valueOf(c);
            resultList.add(cStr);
            List<String> childList = this.totalSort(alpha.replace(cStr, ""));
            for (String childStr : childList) {
                resultList.add(cStr + childStr);
            }
        }
        return resultList;
    }
}
