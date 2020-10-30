package leetcode.editor.cn;
//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 排序 数组 
// 👍 42 👎 0

import java.util.Arrays;

public class SubSortLcci{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] subSort(int[] array) {
        if (array.length < 2) {
            return new int[]{-1, -1};
        }
        int[] a2 = Arrays.copyOf(array, array.length);
        Arrays.sort(a2);
        int l=0;
        int r = array.length - 1;

        while (l < array.length && a2[l] == array[l]) {
            l++;
        }
        if (l == array.length) {
            return new int[]{-1, -1};
        }
        while (a2[r] == array[r]) {
            r--;
        }
        return new int[]{l, r};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SubSortLcci().new Solution();
//        int[] ints = s.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        int[] ints = s.subSort(new int[]{1, 6, 5, 7, 9});
        A.p(ints);

    }
}





























































