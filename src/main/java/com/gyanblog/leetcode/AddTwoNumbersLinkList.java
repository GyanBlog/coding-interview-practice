package com.gyanblog.leetcode;

/**
 * A node of link list
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * Leet code Problem-2 Add Two Numbers gien as link list in reverse order
 * For explanation: https://www.gyanblog.com/gyan/coding-interview/leetcode-solutions-add-two-numbers-link-list/
 */
public class AddTwoNumbersLinkList {

    private static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) { 
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (l1 != null) { sum += l1.val; }
        if (l2 != null) { sum += l2.val; }

        if (sum > 9) { 
            sum = sum - 10;
            carry = 1; 
        }
        else {
            carry = 0;
        }

        ListNode newNode = new ListNode(sum);
        newNode.next = addTwoNumbersHelper(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return newNode;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    public static void showList(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.val);//.append(",");
            list = list.next;
        }

        StringBuilder number = new StringBuilder();
        for (int i=sb.length()-1; i>=0; i--) {
            number.append(sb.charAt(i));
        }

        System.out.println(sb.toString() + " --> " + number.toString());
    }
    /**
     * prepare link list from array
     */
    public static ListNode prepareList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode l1 = new ListNode(arr[0]);
        ListNode head = l1;
        for (int i=1; i<arr.length; i++) {
            l1.next = new ListNode(arr[i]);
            l1 = l1.next;
        }
        l1.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = prepareList(new int[]{2, 4, 3});
        ListNode l2 = prepareList(new int[]{5, 6, 4});
        ListNode sum = addTwoNumbers(l1, l2);
        showList(l1);
        showList(l2);
        System.out.println("Sum: ");
        showList(sum);
        System.out.println("-----------------------------");

        l1 = prepareList(new int[]{9, 8, 7});
        l2 = prepareList(new int[]{8, 6, 7});
        sum = addTwoNumbers(l1, l2);
        showList(l1);
        showList(l2);
        System.out.println("Sum: ");
        showList(sum);
    }
}