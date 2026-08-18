class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode lst = root.left;
        TreeNode rst = root.right;
        root.left = null;
        // root.right = null;
        flatten(lst);
        flatten(rst);
        root.right = lst;
        TreeNode last = root; // ye lst ka last element hoga
        while(last.right!=null) last = last.right;
        last.right = rst;

    }
}
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
