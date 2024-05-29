package DAY13Assignments;

/*Task 1: Balanced Binary Tree Check
Write a function to check if a given binary tree is balanced. A balanced tree is one where the height of two subtrees of any node never differs by more than one.

A balanced binary tree, also known as a height-balanced binary tree, is one where the difference in height between the left and right subtrees of any node is no more than one. Here’s a  function that checks if a binary tree is balanced:*/


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Not balanced
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Not balanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height
    }
}



/*In this Java code:

The TreeNode class defines the structure of each node in the binary tree.
The BalancedBinaryTree class contains the method isBalanced which initiates the check.
The checkHeight method recursively calculates the height of the subtrees and checks for balance at each node.
If an imbalance is detected, -1 is returned to indicate that the tree is not balanced.
The isBalanced method returns true if the tree is balanced, otherwise false.
You can create an instance of BalancedBinaryTree and call the isBalanced method with the root of your tree to check if it’s balanced.*/