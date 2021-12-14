package firsttheme;

import java.util.stream.Stream;

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

class TreeSolution {
    public static int maxDepth(TreeNode root) {
        return Stream.of(root).mapToInt(r -> {
            if (root == null) {
                return 0;
            }
            int dLeft = maxDepth(root.left);
            int dRight = maxDepth(root.right);
            return (dLeft > dRight) ? (dLeft + 1) :  (dRight + 1);
        }).findFirst().getAsInt();
    }
}


