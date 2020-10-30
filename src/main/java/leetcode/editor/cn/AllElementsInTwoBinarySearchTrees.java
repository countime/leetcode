package leetcode.editor.cn;
//给你 root1 和 root2 这两棵二叉搜索树。 
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
// 
//
// 示例 3： 
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
// 
//
// 示例 4： 
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 5000 个节点。 
// 每个节点的值在 [-10^5, 10^5] 之间。 
// 
// Related Topics 排序 树 
// 👍 36 👎 0

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int idx2 = 0;
        int len2 = 0;
        List<Integer> list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            toList(root2, list2);

            len2 = list2.size();

            rec(root1);
            while (idx2 < len2) {
                res.add(list2.get(idx2++));
            }
            return res;
        }


        void rec(TreeNode root) {
            if (root == null) {

                return;
            }
            rec(root.left);

            while (idx2 < len2 && root.val > list2.get(idx2)) {
                res.add(list2.get(idx2++));
            }
            res.add(root.val);

            rec(root.right);
        }

        void toList(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            toList(root.left, list);
            list.add(root.val);
            toList(root.right, list);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new AllElementsInTwoBinarySearchTrees().new Solution();
        TreeNode t1 = TreeNode.of(2, 1, 1);
        TreeNode t2 = TreeNode.of(1, 0, 3);
        List<Integer> res = s.getAllElements(t1, t2);
        A.p(res);
    }
}
































