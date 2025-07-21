class TreeNode{
    int val ;
    TreeNode left ; 
    TreeNode right ; 
    TreeNode(int val){
        this.val = val ; 
    }
}
class BinarySearchTree {
    public static TreeNode generateBST(int[]arr,int si  , int ei){
        if(si>ei) return null ; 
        int mid  = (si + ei) / 2 ; 
        TreeNode root  = new TreeNode(arr[(si+ei)/2]) ; 
        root.left = generateBST(arr, si, mid - 1) ; 
        root.right = generateBST(arr, mid + 1, ei) ; 
        return root  ; 
    }
    public static int minBST(TreeNode root){
        if(root==null) return Integer.MAX_VALUE ; 
        if(root.left==null) return root.val ; 
        return minBST(root.left) ; 
    } 
    public static int minBSTI(TreeNode root){
        TreeNode temp = root ; 
        while(temp.left!=null){
            temp = temp.left ; 
        }
        return temp.val ; 
    }
    
    public static int maxBST(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.right == null)
            return root.val;
        return maxBST(root.right);
    }

    public static int maxBSTI(TreeNode root) {
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.val;
    }
    public static void display(TreeNode root){
        if(root==null)return  ; 
        String dis = (root.left == null ? "." : root.left.val +"" )+ " <-- " + root.val + " --> " + (root.right ==null ? "." : root.right.val +" " );
        System.out.println(dis) ; 
        display(root.left);
        display(root.right) ; 
    }
   public static void main(String[] args) {
    System.out.println("Hello");
    int arr[] = {2,5,9,11,34,45,55,61,69,71,85} ; 
    TreeNode root = generateBST(arr, 0, arr.length-1) ; 
    display(root) ; 
    System.out.println(minBST(root));
    System.out.println(maxBST(root));
   } 
}
