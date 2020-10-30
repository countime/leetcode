package leetcode.editor.cn;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 129 👎 0

public class SortArrayByParityIi{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int b = 1;
        for (int i = 0; i < A.length; i+=2) {
            if (A[i] % 2 == 1) {
//                System.out.println("错误a: " + 2 * i + " " + A[2 * i]);
                while (A[b] % 2 == 1) {
                    b+=2;
                }
//                System.out.println("错误b: " + (2 * b + 1) + " " + A[2 * b + 1]);
                //交换ab.
                int tmp=A[i];
                A[i] = A[b];
                A[b] = tmp;
                b+=2;
            }
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SortArrayByParityIi().new Solution();
        s.sortArrayByParityII(new int[]{4, 2, 5, 7});
    }
}