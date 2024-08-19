package com.example.algorithm.Leetcode;

public class sol1302 {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        int maxDepth = 0;
        int sum = 0;
        public int deepestLeavesSum(TreeNode root) {
            // calMaxDepth(root,0);
            dfs(root,0);
            return sum;
        }

        //  private void calMaxDepth(TreeNode root, int depth){
        //      if(root == null) return;
        //     if(root.left == null && root.right == null) {
        //         maxDepth = Math.max(maxDepth, depth);
        //     }
        //     calMaxDepth(root.left, depth+1);
        //     calMaxDepth(root.right, depth+1);
        //  }

        private void dfs(TreeNode root, int depth){
            if(root == null) return;

            if(depth > maxDepth){
                maxDepth = depth;
                sum = root.val;
            } else if(maxDepth == depth && root.left == null && root.right == null) {
                sum += root.val;
            }
            // if(root.left == null && root.right == null) {
            //     // maxDepth = Math.max(maxDepth, depth);
            //     if(maxDepth <= depth){
            //         System.out.println(depth);
            //         System.out.println(root.val);
            //         sum += root.val;
            //     }
            // }
            dfs(root.left, depth+1);
            dfs(root.right, depth+1);

        }
    }
}
