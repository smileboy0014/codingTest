package com.example.algorithm.Leetcode;

public class sol2331 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // 0 = false, 1 = true, 2 = or , 3 = and
        static class Solution {
            public boolean evaluateTree(TreeNode root) {
                if (root.left == null && root.right == null) {
                    if (root.val == 0) return false;
                    return true;
                }
                boolean left = evaluateTree(root.left);
                boolean right = evaluateTree(root.right);

                if (root.val == 2) return left || right;
                return left && right;
            }
        }
    }
}
