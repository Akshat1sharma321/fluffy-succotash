import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    int state;
    TreeNode node;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }

}

public class btr {
    public static TreeNode constructTree(Integer[] arr) {
        TreeNode root = null;
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            Integer element = arr[i];

            if (element == null) {
                if (st.size() == 0) {
                    return null;
                }
                if (st.peek().state == 1) {
                    st.peek().state++;
                } else {
                    st.pop();
                }
            } else {
                TreeNode ne = new TreeNode(element);
                if (st.size() == 0) {
                    root = ne;
                    st.add(new Pair(root, 1));
                } else {
                    Pair top = st.peek();
                    if (top.state == 1) {
                        top.node.left = ne;
                        top.state++;
                    } else {
                        top.node.right = ne;
                        st.pop();
                    }
                    st.add(new Pair(ne, 1));
                }

            }
        }
        return root;
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void display(TreeNode root) {
        if (root == null)
            return;
        String curr = "";
        curr = (root.left == null ? "." : root.left.val + "") + "<--" + root.val + "-->"
                + (root.right == null ? "." : root.right.val + "");
        System.out.println(curr);
        display(root.left);
        display(root.right);
    }

    public static void traversals(ArrayList<Integer> pre, ArrayList<Integer> in, ArrayList<Integer> post,
            TreeNode root) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        traversals(pre, in, post, root.left);
        in.add(root.val);
        traversals(pre, in, post, root.right);
        post.add(root.val);
    }

    public static void traversalsIterative(ArrayList<Integer> pre, ArrayList<Integer> in, ArrayList<Integer> post,
            TreeNode root) {
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(root, 1));
        while (st.size() > 0) {
            TreeNode top = st.peek().node;
            int state = st.peek().state;
            if (state == 1) {
                st.peek().state++;
                pre.add(top.val);
                if (top.left != null) {
                    st.add(new Pair(top.left, 1));
                }
            } else if (state == 2) {
                st.peek().state++;
                in.add(top.val);
                if (top.right != null) {
                    st.add(new Pair(top.right, 1));
                }
            } else {
                post.add(top.val);
                st.pop();
            }
        }
        System.out.println("Preorder Iterative--> " + pre);
        System.out.println("Inorder Iterative --> " + in);
        System.out.println("Postorder Iterative--> " + post);
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 11, null, 15, null, null, 12, 14, null, null, null, 30, null, 13, 16, null, null, 17,
                null, null };
        TreeNode root = constructTree(arr);
        display(root);
        System.out.println(height(root));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        // traversals(pre, in, post, root);
        // System.out.println("Preorder --> " + pre);
        // System.out.println("Inorder --> "+ in);
        // System.out.println("Postorder --> " + post);
        traversalsIterative(pre, in, post, root);
    }
}

// LeetCode 863...
class Solution {
    public ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode target) {
        if (root == null)
            return new ArrayList<TreeNode>();
        if (root.val == target.val) {
            ArrayList<TreeNode> bans = new ArrayList<>();
            bans.add(root);
            return bans;
        }
        ArrayList<TreeNode> left = nodeToRootPath(root.left, target);
        if (left.size() > 0) {
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = nodeToRootPath(root.right, target);
        if (right.size() > 0) {
            right.add(root);
            return right;
        }
        return new ArrayList<TreeNode>();
    }

    public void getNodesByK(ArrayList<Integer> result, TreeNode blocker, TreeNode src, int dist) {
        if (src == null || dist < 0) {
            return;
        }

        if (src == blocker) {

            return;
        }
        if (dist == 0) {
            result.add(src.val);
            return;
        }

        getNodesByK(result, blocker, src.left, dist - 1);
        getNodesByK(result, blocker, src.right, dist - 1);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> ntr = nodeToRootPath(root, target);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < ntr.size(); i++) {
            TreeNode blocker = i == 0 ? null : ntr.get(i - 1);
            TreeNode currentNode = ntr.get(i);
            getNodesByK(result, blocker, currentNode, k - i);
        }
        return result;
    }
}