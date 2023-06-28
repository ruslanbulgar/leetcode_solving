package com.rbcode.leatcode.removeNthFromEnd;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        Integer sz = getListSize(head);

        if (sz == 1 || n > sz) {
            return null;
        }
        int n1 = sz-n;

        if(n1 == 0) {
            return head.next;
        }

        int index = 0;
        ListNode current = head;

        while (current != null) {
            if (index+1 == n1 && current.next != null) {
                current.next = current.next.next;
                break;
            }
            current = current.next;

            index++;
        }

        return head;
    }

    private Integer getListSize(ListNode head) {
        ListNode element = head;
        Integer size = 0;
        do {
            size++;
            element = element.next;
        } while (element != null);
        return size;
    }

    public static void main(String[] args) {
        ListNode head = getHeadOfList(Arrays.asList(1,2,3));
        Solution solution = new Solution();
        solution.sout(head);
        ListNode updated = new Solution().removeNthFromEnd(head, 3);
        solution.sout(updated);
    }

    private void sout(ListNode head) {
        ListNode element = head;
        System.out.print("[");
        while (element != null) {
            System.out.print(element.val);
            element = element.next;
            if (element != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    private static ListNode getHeadOfList(List<Integer> elements) {
        if (elements == null || elements.size() < 1) {
            return null;
        }

        ListNode head = null;

        ListNode element = null;

        for (Integer e : elements) {

            if (head == null) {
                head = new ListNode(e);
                element = head;
            } else {
                element.next = new ListNode(e);
                element = element.next;
            }
        }
        return head;
    }
}
