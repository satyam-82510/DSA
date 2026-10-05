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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode> q= new LinkedList<TreeNode>();
         List<List<Integer>> wrapList= new LinkedList<List<Integer>>();
         if (root==null) return wrapList;
         q.offer(root);
         while(!q.isEmpty()){
            int size= q.size();
            List<Integer> subList= new LinkedList<>();
            for(int i=0;i<size;i++){
                if (q.peek().left!= null) q.offer(q.peek().left);
                if (q.peek().right!= null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            wrapList.add(subList);
         }
    return wrapList;
    }
}

// using TreeNode = q.poll() store than cur use METHOD Same
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();

//         if(root == null)
//             return ans;

//         q.offer(root);

//         while(!q.isEmpty()){
//             int len = q.size();
//             List<Integer> list = new ArrayList<>();

//             for(int i=1;  i<=len; i++){
//                 TreeNode cur = q.poll();
//                 list.add(cur.val);
//                 if(cur.left != null)
//                     q.offer(cur.left);
//                 if(cur.right != null)
//                     q.offer(cur.right);
//             }

//             ans.add(list);
//         }

//         return ans;
//     }
// }