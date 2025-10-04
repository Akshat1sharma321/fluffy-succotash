public class Question24_LCAInBT {
    public boolean lca(TreeNode root, TreeNode p, TreeNode q, TreeNode[] ans) {
        if (root == null)
            return false;
        Boolean self = false;
        if (root == p || root == q)
            self = true;
        Boolean left = lca(root.left, p, q, ans);
        Boolean right = lca(root.right, p, q, ans);
        if (ans[0] != null)
            return true;
        if ((self && left) || (self && right) || (left && right)) {
            self = true;
            ans[0] = root;
        }
        return self || left || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[1];
        lca(root, p, q, ans);
        return ans[0];
    }
}
