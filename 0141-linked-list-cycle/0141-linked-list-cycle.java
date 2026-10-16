/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// THIS IS THE BRUTE APPROACH FOR DETECT A CYCLE
// TIME COMPLEXITY: O(N) - We traverse the linked list of N nodes once. HashMap operations take O(1) time on average.
// SPACE COMPLEXITY: O(N) - In the worst case, all nodes are stored in the HashMap.
// 1. Easy to think of: It's like walking in a maze and dropping a small stone every time you visit a room. If you step on a room where you already see your stone, you immediately know you are walking in a circle.
//2. Can store extra details: Since you are using a map, you can easily save extra information along with each node (like how many times you visited it, or a specific timestamp), which a simple pointer cannot do easily. (Note: Tortoise & Hare is typically preferred for O(1) space complexity)
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         // Use ListNode instead of Node to match LeetCode's definition
//         ListNode temp = head;//not int temp also node in LL
        
//         // Use ListNode as the key in the HashMap
//         HashMap<ListNode, Integer> map = new HashMap<>();
        
//         while (temp != null) {
//             if (map.containsKey(temp)) {
//                 return true;
//             }
//             map.put(temp, 1);
//             temp = temp.next;
//         }
        
//         return false;
//     }
// }


// Tortoise & Hare(OPTIMAL APPROACH)
/*
  TC: O(N) - The fast pointer will traverse the list of N nodes at most once before meeting the slow pointer or reaching the end.
  SC: O(1) - Only two pointers (slow and fast) are used, requiring constant extra space.
 */
 //BIGGEST MISTAKE AND ERROR WE DO CAN RUN BUT NOT CORRECT (BELOW ONE IN LAST IS CORRECT)
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         // Use ListNode instead of Node to match LeetCode's definition
//         ListNode slow = head;
//         ListNode fast = head;
//         //not int temp also node in LL
        
//         while (fast!=null && fast.next!=null ) {//O(n)
//             if (slow==fast) {
//                 return true;
//             }
//            fast=fast.next.next;//note two times next as fast move two times then slow
//            slow=slow.next;
//         }
        
//         return false;
//     }
// }


//CORRECT ONE 
// MISTAKE: Order of Check vs. Movement
// In the failed version (top): You check if (slow == fast) before moving the pointers. Since both start at head, slow == fast is instantly true on the very first iteration, causing it to incorrectly return true immediately even if there is no cycle! You must move the pointers first before checking if they meet.

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by 1 step
            fast = fast.next.next;     // Move fast by 2 steps
            
            if (slow == fast) {        // Check AFTER moving
                return true;
            }
        }
        
        return false;
    }
}