package com.leetcode.二叉树的最小深度;

/**
 * @author Zereao
 * @version 2020/4/16 11:30
 */
class Solution {
    /**
     * 本题需要注意的是：
     * <p>
     * |           1
     * |          /
     * |         2
     * |        /
     * |       3
     * <p>
     * 如上面这棵树，其深度为 3，而不是1；所以，针对每个结点，需要判断：
     * 当其左结点为空时，返回右子树最小深度；
     * 当其右结点为空时，返回左子树最小深度；
     *
     * @param node 结点
     * @return 最小深度
     */
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return this.minDepth(node.right) + 1;
        }
        if (node.right == null) {
            return this.minDepth(node.left) + 1;
        }
        int leftDepth = this.minDepth(node.left);
        int rightDepth = this.minDepth(node.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

}
