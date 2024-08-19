package com.example.algorithm.Leetcode;

public class sol1302 {


    public class TreeNode {
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
    }

    class Solution {
        int maxLevel = 0;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            if (root == null) return 0;
            dfs(root, 0);

            return sum;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) return;
            if (level > maxLevel) {
                sum = 0;
                maxLevel = level;
            }
            if (level == maxLevel) {
                sum += root.val;
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}
