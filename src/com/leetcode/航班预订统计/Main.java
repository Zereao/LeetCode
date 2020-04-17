package com.leetcode.航班预订统计;

import java.util.Arrays;

/**
 * @author Zereao
 * @version 2020/4/6 14:16
 */
public class Main {

    private int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;
            int seatCount = bookings[i][2];
            for (int j = start; j <= end; j++) {
                result[j] += seatCount;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main a = new Main();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] r = a.corpFlightBookings(bookings, 5);
        System.out.println(Arrays.toString(r));
    }
}
