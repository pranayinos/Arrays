package LeetCode2;

/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

[1,6,0,3,3,6,7,2,0,1]
[6,3,0,8,9,6,6,9,6,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode( 4, new ListNode(3)));
        print(l1);
        ListNode l2 = new ListNode(5, new ListNode( 6, new ListNode(4)));
        print(l2);
        Solution sol = new Solution();
        print(sol.addTwoNumbers(l1, l2));
    }

    private static void print(ListNode l) {
        System.out.println();
        while (l != null){
            System.out.print(l.val +"->");
            l = l.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumHead = null;
        ListNode sumRunner = null;
        while (true){
            int d1, d2;
            if(l1!=null){
                d1 = l1.val;
                l1 = l1.next;
            } else {
                d1 = 0;
            }
            if(l2!=null){
                d2 = l2.val;
                l2 = l2.next;
            } else {
                d2 = 0;
            }
            int sumDigits = d1 + d2 + carry;
            if(sumDigits > 9){
                sumDigits = sumDigits%10;
                carry=1;
            }else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sumDigits);
            newNode.next=null;
            if(sumHead == null){
                sumRunner = newNode;
                sumHead=sumRunner;
            } else {
                sumRunner.next = newNode;
                sumRunner = sumRunner.next;
            }
            if(l2==null && l1==null && carry==0){
                break;
            }

        }
        return sumHead;
    }

}
