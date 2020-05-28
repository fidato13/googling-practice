package com.trn.sol;

public class MergeTwoLists {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = l1; // this would be our node which will be returned as answer

        ListNode temp = l1;

        while(l1 != null && l2 != null){
            temp = l1;
            l1 = l1.next;
            temp.next = l2;
            temp = l2;
            l2 = l2.next;
            temp.next = l1;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = three;
        three.next = five;

        two.next = four;
        four.next = six;

        mergeTwoLists(one, two);
    }
}
