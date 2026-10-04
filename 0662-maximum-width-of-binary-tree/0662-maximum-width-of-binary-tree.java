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
//  class Pair{
//     TreeNode node;
//     int num;
//     Pair(TreeNode node, int num){
//         this.node = node;
//         this.num = num;

//     }
//  }
// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         if (root==null) return 0;
//         int maxwidth= 0;
//         Queue<Pair> q= new LinkedList<>();
//         q.add(new Pair(root,0));
//         while(!q.isEmpty()){
//             int size = q.size();
//             int minIndex = q.peek().num;// queue is fifo  always give you leftmost node of the level 
//             int first = 0, last=0;
//             for (int i = 0; i< size; i++){
//               Pair current=  q.poll();
//             int exactIndex= current.num- minIndex;
//             if (i==0) first = exactIndex;
//             if (i==size-1) last = exactIndex;
//             if (root.left!= null) q.add(new Pair(root.left, 2*exactIndex+1));
//             if (root.right!=null) q.add(new Pair(root.right, 2*exactIndex+2));
//             }
//             maxwidth = Math.max(maxwidth, last-first +1);
//         }
        
//         return maxwidth;
//     }
// }

class Solution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();

        // Root gets index 1
        queue.offer(new Pair(root, 1));

        long maxWidth = 0;

        while (!queue.isEmpty()) {

            // Number of nodes in the current level
            int levelSize = queue.size();

            long firstIndex = 0;
            long lastIndex = 0;

            // Process the current level
            for (int i = 0; i < levelSize; i++) {

                Pair current = queue.poll();

                TreeNode node = current.node;
                long index = current.index;

                // First node of this level
                if (i == 0) {
                    firstIndex = index;
                }

                // Last node of this level
                if (i == levelSize - 1) {
                    lastIndex = index;
                }

                // Left child
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index));
                }

                // Right child
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            // Width of the current level
            long width = lastIndex - firstIndex + 1;

            // Update maximum width
            maxWidth = Math.max(maxWidth, width);
        }

        return (int) maxWidth;
    }
}