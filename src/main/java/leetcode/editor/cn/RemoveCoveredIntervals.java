package leetcode.editor.cn;
//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
// Related Topics 贪心算法 排序 Line Sweep 
// 👍 20 👎 0

import java.util.Arrays;

public class RemoveCoveredIntervals{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->{
            if (a[0] != b[0]) {
                return a[0]-b[0];
            } else {
                return b[1] - a[1];
            }
        });
//        A.p(intervals);

        int l = intervals[0][0], r = intervals[0][1];
        int res=1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= r) {
                //被包含在上一个范围中
            } else {
                // 只要没被包含,必然可以作为新的范围.
                l=intervals[i][0];
                r = intervals[i][1];
                res++;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new RemoveCoveredIntervals().new Solution();
//        int i = s.removeCoveredIntervals(new int[][]{new int[]{1, 4}, new int[]{2, 3}});
        int i = s.removeCoveredIntervals(new int[][]{new int[]{1, 4}, new int[]{3, 6},
        new int[]{2,8}});
        System.out.println(i);
    }
}