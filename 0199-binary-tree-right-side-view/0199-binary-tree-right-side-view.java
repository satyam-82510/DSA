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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();
            rightView(root,result,0);
            return result;    
    }
    public void rightView(TreeNode curr,List<Integer> result, int currentDepth){
        if (curr == null){
            return;
        }
        if(currentDepth==result.size()){// when vist first time a depth the result is added next time automatically list.size is +1 as we already add in previous one one element in list
            result.add(curr.val);
        }
        rightView(curr.right,result,currentDepth + 1);
        rightView(curr.left,result,currentDepth + 1);
    }
}