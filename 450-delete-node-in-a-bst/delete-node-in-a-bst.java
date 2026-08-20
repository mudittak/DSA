/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int target) {
        if(root==null) return null;
        if(root.val > target) // go left
            root.left = deleteNode(root.left,target);
        else if(root.val < target) // go right
            root.right = deleteNode(root.right,target);
        else{ // root.data == target
            // Case 1 (Leaf Node)
            if(root.left==null && root.right==null) return null;
            // Case 2 (1 child node)
            if(root.right==null) return root.left;
            if(root.left==null) return root.right;
            // Case 3 (2 Child Nodes)
            TreeNode pred = root.left;
            while(pred.right!=null) pred = pred.right;
            root.left = deleteNode(root.left,pred.val);
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }
        return root;
        
    }
}