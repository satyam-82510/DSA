/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head){
    //3. Optimised Best APPROACH(TORTISE AND HARE ALSO KNOW AS SLOW FAST POINTER)
    // TC = O(N) , SC = O(1)
    // Node slow = head;-> wrong here as ll clase node name is ListNode not Node only
    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast=fast.next.next;
    } 
    return slow;  
    }
}

// // BRUTE FORCE APPROACH
// //  TC = O(N)+O(N/2) , SC =O(1)
//     ListNode temp = head;
//     int count = 0;
//     while(temp!=null){
//         count++;
//         temp=temp.next;
//     }
//     int middleNode= (count/2)+1;
//     // ListNode temp = head; ->This is Wrong because Reuse any variable without Redeclaration if once is declared already no need (or wrong) if again you declared
//     temp = head;
//     while(middleNode!=0){
//         middleNode--;
//         if(middleNode==0) break;
//         temp=temp.next;
//     }
//     return temp;
// }
// }