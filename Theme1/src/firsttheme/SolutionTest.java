package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static firsttheme.Solution.*;

public class SolutionTest {

    @Test
    public void removeNthFromEndTest() {
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = new ArrayList<>();

        int[][] arrays = {
                {1,2,3,4,5},
                {1},
                {1,2},
                {1,3,5,7,9,11},
                {5,4,3,2,1}};
        int[] ns = {2,1,1,3,4};

        expected.add(Arrays.asList(1,2,3,5));
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1,3,5,9,11));
        expected.add(Arrays.asList(5,3,2,1));

        ListNode head;
        for(int i = 0; i < 5; i++) {
            head = createListOfNodes(arrays[i]);
            actual.add(nodeListToArrayList(removeNthFromEnd(head, ns[i])));
        }

        assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNthFromEndNegativeNTest() {
        int[] arr = {1,2,3,4};
        ListNode head = createListOfNodes(arr);
        removeNthFromEnd(head, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNthFromEndTooBigNTest() {
        int[] arr = {1,2,3,4};
        ListNode head = createListOfNodes(arr);
        removeNthFromEnd(head, 5);
    }

    @Test(expected = NullPointerException.class)
    public void removeNthFromEndNullTest() {
        removeNthFromEnd(null,1);
    }
}