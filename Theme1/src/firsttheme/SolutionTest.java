package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static firsttheme.Solution.*;

public class SolutionTest {

    @Test
    public void maxDepthTest() {
        List<Integer> expected = Arrays.asList(3,2,0,1,4);
        List<Integer> actual = new ArrayList<>();

        TreeNode[] roots = new TreeNode[5];
        //[3,9,null,null,20,15,7]
        roots[0] =
                new TreeNode(3,
                        new TreeNode(9,
                                null,
                                null),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)));
        //[1,null,2]
        roots[1] =
                new TreeNode(1,null,new TreeNode(2));
        //[]
        roots[2] = null;
        //[0]
        roots[3] = new TreeNode(0);
        //|              10,
        //|        7                 17,
        //|   4,       11          10,null
        //| 0,null
        roots[4] =
                new TreeNode(10,
                        new TreeNode(7,
                                new TreeNode(4,
                                        new TreeNode(0),
                                        null),
                                new TreeNode(11)),
                        new TreeNode(17,
                                new TreeNode(10),
                                null));

        for(TreeNode root : roots) {
            actual.add(maxDepth(root));
        }

        assertEquals(expected,actual);
    }
}