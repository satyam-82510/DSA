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

 // Comparison of In-Order Traversals:
// 1. Recursive:        Time = O(N), Space = O(H) auxiliary stack space
// 2. Iterative Stack:  Time = O(N), Space = O(H) auxiliary stack space
// 3. Morris Traversal: Time = O(N), Space = O(1) auxiliary space (modifies tree pointers temporarily)

// MORRIS TRAVERSAL VS OTHER TRAVERSALS EXPLANATION:
// 
// 1. RECURSIVE TRAVERSAL:
//    - TC: O(N) -> Every node is visited once during the function recursion.
//    - SC: O(H) -> Uses system call stack memory. Height H = log N for balanced trees, O(N) for skewed trees.
//    - Mechanism: Simple to implement, relies on implicit function call stack to backtrack to parent nodes.
//
// 2. ITERATIVE TRAVERSAL (USING STACK):
//    - TC: O(N) -> Every node is pushed and popped from the stack once.
//    - SC: O(H) -> Uses an explicit Stack data structure to store nodes. Worst case O(N) for skewed trees.
//    - Mechanism: Replicates recursion manually by storing parent nodes in a Stack to backtrack later.
//
// 3. MORRIS TRAVERSAL (THREADED BINARY TREE):
//    - TC: O(N) -> Amortized O(N). Each edge is traversed at most 3 times (finding predecessor, setting thread, removing thread).
//    - SC: O(1) -> Truly constant auxiliary space. Uses no stack or recursion.
//    - Mechanism: Temporarily links the rightmost child of the left subtree (in-order predecessor) 
//                 to the current node (curr). This creates a temporary "thread" back to the parent 
//                 without using external space, and cleans it up during the second pass.

// //1. MORRIS TRAVERSAL(INORDER )
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {// THAT IS A INORDER (FOR PREORDER A ONE LINE CHANGE IN A CODE WE PRINT A ROOT BEFORE MOVE A CURR IN STARTING ONLY 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        TreeNode curr= root;
        while(curr!=null){
            // case 1
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            } else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev= prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                } else{
                    prev.right =null;
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}

//2. MORRIS TRAVERSAL(PREORDER )
// class Solution {//FOR PREORDER A ONE LINE CHANGE IN INORDER CODE( WE PRINT A ROOT BEFORE MOVE A CURR IN STARTING ONLY)
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list= new ArrayList<>();
//         TreeNode curr= root;
//         while(curr!=null){
//             // CASE 1
//             if(curr.left==null){
//                 list.add(curr.val);
//                 curr=curr.right;
//             } else{ //CASE 2
//                 TreeNode prev=curr.left;
//                 while(prev.right!=null && prev.right!=curr){
//                     prev= prev.right;
//                 }
//                 if(prev.right==null){
//                     prev.right=curr;
//                     list.add(curr.val);//THIS LINE ONLY (WE ADD A LIST OR PRINT BFORE MOVE CURR IN STARTING ONLY)
//                     curr=curr.left;
//                 } else{
//                     prev.right =null;
//                     curr=curr.right;// NOW NO PRINT SIMPLE MOVE FORWARD WITHOUT PRINT AS WE ALREADY PRINT/ADD IN LIST 
//                 }
//             }
//         }
//         return list;
//     }
// }


// FOR FAST REVISION WITH COMMENTS (INORDER)
// class Solution {
//     /**
//      * Morris Inorder Traversal (Root-Left-Right -> Inorder visit order: Left, Root, Right)
//      * Time Complexity: O(N) - Every edge is visited at most 3 times.
//      * Space Complexity: O(1) - Modifies tree pointers temporarily without using recursion or stack.
//      */
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         TreeNode curr = root;

//         while (curr != null) {
            
//             // CASE 1: No left subtree exists.
//             // Since there is no left child to process, process the current node 
//             // and move to its right child (which could be an actual child or a thread back to an ancestor).
//             if (curr.left == null) {
//                 list.add(curr.val);
//                 curr = curr.right;
//             } 
//             // CASE 2: Left subtree exists.
//             else {
//                 // Find the Inorder Predecessor of `curr` 
//                 // (the rightmost node in the left subtree).
//                 TreeNode prev = curr.left;
//                 while (prev.right != null && prev.right != curr) {
//                     prev = prev.right;
//                 }

//                 // SUBCASE 2A: Thread Creation
//                 // `prev.right` is null -> We haven't visited this left subtree yet.
//                 // 1. Create a temporary thread pointing from `prev` to `curr`.
//                 // 2. Move `curr` to its left child to process the left subtree first.
//                 if (prev.right == null) {
//                     prev.right = curr;
//                     curr = curr.left;
//                 } 
//                 // SUBCASE 2B: Thread Removal & Processing
//                 // `prev.right == curr` -> We have finished processing the left subtree and followed the thread back.
//                 // 1. Remove the temporary thread to restore tree structure (`prev.right = null`).
//                 // 2. Visit the current node (`list.add(curr.val)`).
//                 // 3. Move to the right subtree (`curr = curr.right`).
//                 else {
//                     prev.right = null;
//                     list.add(curr.val);
//                     curr = curr.right;
//                 }
//             }
//         }

//         return list;
//     }
// } 

// THIS IS A SIMPLE INORDER APPROACH BELOW AS NO OTHER QUESTION SPECIFIC OF MORRIS TRAVERSAL ON LEETCODE

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> li=new ArrayList<>();
//         inOrder(root,li);
//         return li;
//     }
//     void inOrder(TreeNode root,List<Integer> li)
//     {
//         if(root==null) return;
//         inOrder(root.left,li);
//         li.add(root.val);
//         inOrder(root.right,li);
//     }
// }
