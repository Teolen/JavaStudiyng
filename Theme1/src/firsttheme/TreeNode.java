package firsttheme;

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
}


