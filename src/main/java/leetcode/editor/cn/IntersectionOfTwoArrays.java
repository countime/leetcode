package leetcode.editor.cn;
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 240 👎 0

import java.util.Arrays;
import java.util.TreeSet;

public class IntersectionOfTwoArrays{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] tmp;
        if (nums1.length > nums2.length) {
            tmp=nums1;
            nums1=nums2;
            nums2 = tmp;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int[] result = new int[nums1.length];
        int idx=0;
        for (int i : nums2) {
            if (set.contains(i)) {
                result[idx++] = i;
                set.remove(i);
            }
        }
        return Arrays.copyOfRange(result, 0, idx);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new IntersectionOfTwoArrays().new Solution();


        int[] intersection = s.intersection(new int[]{1, 2, 3}, new int[]{4, 2, 1});
        A.p(intersection);

    }
}