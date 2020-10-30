package leetcode.editor.cn;
//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 656 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length ==0) {
            return intervals;
        }
        // TODO: 2020/10/21  
        Arrays.sort(intervals, 0, intervals.length, Comparator.comparingInt(e -> e[0]));

        int[][] result = new int[intervals.length][2];
        int idx=0;
        int[] last=intervals[0];
        result[idx++] = last;
        for (int i = 1; i < intervals.length; i++) {
            // 不相连
            if (last[1] < intervals[i][0]) {
                last = intervals[i];
                result[idx++] = last;
            } else if(intervals[i][1]>last[1]) {
                last[1] = intervals[i][1];
//                last[1] = Math.max(last[1], intervals[i][1]);

            }
        }

        return Arrays.copyOfRange(result,0,idx);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new MergeIntervals().new Solution();
    }
}