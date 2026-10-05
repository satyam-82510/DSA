/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean inOrder(TreeNode root,int sum, int targetSum){
        if(root==null){
            return false;
        }
        sum+= root.val;
        // if we reach at leaf node
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                return true;
            }
            return false;
        }

        boolean leftside= inOrder(root.left,sum,targetSum);
        boolean rightside= inOrder(root.right,sum,targetSum);

        return leftside || rightside;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum=0;
        boolean result= inOrder(root,sum,targetSum);
        return result;
    }
}