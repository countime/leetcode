package leetcode.editor.cn;
//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 输入：[1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 
// Related Topics 堆 排序 
// 👍 49 👎 0

public class DistantBarcodes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int[] cnt = new int[10001];
            for (int e : barcodes) {
                cnt[e]++;
            }
            int maxCnt = 0;
            int maxNum = 0;
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] > maxCnt) {
                    maxNum = i;
                    maxCnt = cnt[i];
                }
            }
//            A.p(cnt);

            int[] res = new int[barcodes.length];
            // 最多的开始放.

            int i = 0;
            for (; i < maxCnt * 2; i += 2) {
                res[i] = maxNum;
            }
            cnt[maxNum] = 0;

            int j = 0;
            // 剩下的偶数位.
            out:
            for (; j < cnt.length; j++) {
                while (cnt[j] > 0) {
                    if (i < barcodes.length) {
                        cnt[j]--;
                        res[i] = j;
                        i += 2;
                    } else {
                        break out;
                    }
                }
            }
            // 剩下的奇数位.
            i = 1;
            for (; j < cnt.length; j++) {
                while (i < barcodes.length && cnt[j] > 0) {
                    cnt[j]--;
                    res[i] = j;
                    i += 2;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new DistantBarcodes().new Solution();
        int[] ints = s.rearrangeBarcodes(new int[]{1, 2, 2, 3});
        A.p(ints);

    }
}