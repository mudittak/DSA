//method 3 by morris traversal but with some modification
class Solution {
    public void flatten(TreeNode root) {
       TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) { // pred nikal sakta hai
                TreeNode pred = curr.left;
                while(pred.right != null) pred = pred.right;
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
            else {
                curr = curr.right;
            }
        }

    }
}

// method 2
// class Solution {
//     public void flatten(TreeNode root) {
//         if(root==null) return;
//         TreeNode lst = root.left;
//         TreeNode rst = root.right;
//         root.left = null;
//         // root.right = null;
//         flatten(lst);
//         flatten(rst);
//         root.right = lst;
//         TreeNode last = root; // ye lst ka last element hoga
//         while(last.right!=null) last = last.right;
//         last.right = rst;

//     }
// }
// Method 1
// class Solution {
//     public void flatten(TreeNode root) {
//         ArrayList<TreeNode> arr = new ArrayList<>();
//         dfs(root,arr);
//         for(int i=0;i<arr.size()-1;i++){
//             TreeNode a = arr.get(i);
//             TreeNode b = arr.get(i+1);
//             a.right = b;
//             a.left = null;
//         }
//         if(arr.size()==0) return;
//         TreeNode last = arr.get(arr.size()-1);
//         last.left = null;
//         last.right = null;
//     }

//     private static void dfs(TreeNode root, ArrayList<TreeNode> arr) {
//         if(root==null) return;
//         arr.add(root);
//         dfs(root.left,arr);
//         dfs(root.right,arr);
//     }
        
//  }
