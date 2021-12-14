package firsttheme;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The argument n is negative or 0");
        }

        ListNode tmp = Objects.requireNonNull(head);

        //finding a length of list
        int length = (int)Stream
                .iterate(head, Objects::nonNull, x -> x.next)
                .count();

        if(length < n) {
            throw new IllegalArgumentException("n is too big");
        }
        //return a head of list without first node
        if(length == n) {
            return head.next;
        }
        //remove a node from various positions(except first)
        // (can't find a solution with Streams)
        for(int i = 0; i < length-n-1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    public static List<Integer> nodeListToArrayList(ListNode head) {
        return Stream.iterate(head, Objects::nonNull, x -> x.next)
                .map(x -> x.val)
                .toList();
    }
    public static ListNode createListOfNodes(int[] vals) {
        if(vals.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        ListNode result = new ListNode(vals[vals.length-1]);

        for(int i = vals.length-2; i >= 0; i--) {
            result = new ListNode(vals[i], result);
        }
        return result;
    }
}
