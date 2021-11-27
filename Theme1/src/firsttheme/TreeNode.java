package firsttheme;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int dLeft = maxDepth(root.left);
        int dRight = maxDepth(root.right);

        if(dLeft > dRight) {
            return dLeft + 1;
        }
        else {
            return dRight + 1;
        }
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode root1 =
                new TreeNode(3,
                new TreeNode(9,null,null),
                new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(maxDepth(root1));
        // [1,null,2]
        TreeNode root2 =
                new TreeNode(1,null,new TreeNode(2));
        System.out.println(maxDepth(root2));
        // []
        TreeNode root3 = null;
        System.out.println(maxDepth(root3));
        // [0]
        TreeNode root4 = new TreeNode(0);
        System.out.println(maxDepth(root4));
    }
}


