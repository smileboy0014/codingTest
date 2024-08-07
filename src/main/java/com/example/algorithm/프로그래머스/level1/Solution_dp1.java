package com.example.algorithm.프로그래머스.level1;

import java.util.ArrayList;
import java.util.List;

public class Solution_dp1 {

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
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeafNode(root1,list1);
        getLeafNode(root2,list2);

        return list1.equals(list2);
    }

    public static void getLeafNode(TreeNode root, List<Integer> list){

        if(root == null) return;

        getLeafNode(root.left, list);

        if(root.left == null && root.right == null){
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(root.val);
            return;
        }
        getLeafNode(root.right, list);

    }

    static boolean Solution(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeafNode(root1,list1);
        getLeafNode(root2,list2);

        return list1.equals(list2);

    }


    public static void main(String[] args) {
//        System.out.println(Solution(new TreeNode));
    }
}
