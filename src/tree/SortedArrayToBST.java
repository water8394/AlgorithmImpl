package tree;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }

    private TreeNode helper(int[] nums, int left, int right) {

        if (left < right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid);
        root.right = helper(nums, mid, right);
        return root;
    }

}
