package firsttheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// if HEAD can be a ListNode without val. Example: [HEAD -> 1 -> 2 -> 3]
public class Solution2 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The argument n is negative or 0");
        }

        int length = 0;
        ListNode tmp = Objects.requireNonNull(head);

        //finding a length of list
        tmp = tmp.next;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        if(length < n) {
            throw new IllegalArgumentException("n is too big");
        }

        //remove a node from various positions
        tmp = head;
        for(int i = 0; i < length-n; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;

    }
    public static ListNode createListOfNodes(int[] vals) {
        if(vals.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        ListNode tmp = null;
        for(int i = vals.length-1; i >= 0; i--) {
            tmp = new ListNode(vals[i], tmp);
        }
        ListNode result = new ListNode();
        result.next = tmp;
        return result;
    }
    public static List<Integer> nodeListToArrayList(ListNode head) {
        ListNode node = head.next;
        List<Integer> result = new ArrayList<>();
        while(node != null) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }
}
