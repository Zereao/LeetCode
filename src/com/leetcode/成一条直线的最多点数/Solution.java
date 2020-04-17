package com.leetcode.成一条直线的最多点数;

import java.util.Objects;

/**
 * @author Zereao
 * @version 2020/4/16 18:01
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length <= 0) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }
        int maxPointNum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i; j < points.length; j++) {
                int pointNumOfThisLine = 0;
                if (points[i].equals(points[j])) {
                    pointNumOfThisLine += 2;
                }
                Variable kb = this.getFunc(points[i], points[j]);
                for (Point point : points) {
                    int y = point.y;
                    int x = point.x;
                    if (y == kb.k * x + kb.b) {
                        ++pointNumOfThisLine;
                    }
                }
                maxPointNum = Math.max(maxPointNum, pointNumOfThisLine);
            }
        }
        return maxPointNum;
    }


    private Variable getFunc(Point a, Point b) {
        int aX = a.x, aY = a.y;
        int bX = b.x, bY = b.y;
        double varK = (bY - aY) * 1.0 / (bX - aX);
        double varB = aY - varK * aX;
        return new Variable(varK, varB);
    }


    private static class Variable {
        Double k;
        Double b;

        public Variable() { }

        public Variable(Double k, Double b) {
            this.k = k;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Variable variable = (Variable) o;
            return Objects.equals(k, variable.k) &&
                    Objects.equals(b, variable.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, b);
        }
    }
}
