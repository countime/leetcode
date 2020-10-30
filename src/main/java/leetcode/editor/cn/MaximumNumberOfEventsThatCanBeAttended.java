package leetcode.editor.cn;
//给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 e
//ndDayi 。 
//
// 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。 
//
// 请你返回你可以参加的 最大 会议数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：events = [[1,2],[2,3],[3,4]]
//输出：3
//解释：你可以参加所有的三个会议。
//安排会议的一种方案如上图。
//第 1 天参加第一个会议。
//第 2 天参加第二个会议。
//第 3 天参加第三个会议。
// 
//
// 示例 2： 
//
// 输入：events= [[1,2],[2,3],[3,4],[1,2]]
//输出：4
// 
//
// 示例 3： 
//
// 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 输入：events = [[1,100000]]
//输出：1
// 
//
// 示例 5： 
//
// 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= events.length <= 10^5 
// events[i].length == 2 
// 1 <= events[i][0] <= events[i][1] <= 10^5 
// 
// Related Topics 贪心算法 排序 线段树 
// 👍 95 👎 0

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;

        public int maxEvents(int[][] events) {
            Arrays.sort(events, (a, b) -> a[0] - b[0]);

            //按照结束时间排序.
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            int idx = 0;

            for (int day = 1; day < 100000; day++) {
                System.out.println("第"+day+"天");
                // 加入当天开始的所有会议,此时queue中的结束日期>=当天
                while (idx < events.length && day == events[idx][0]) {
                    queue.add(events[idx]);
                    idx++;
                }
                if (queue.isEmpty()) {
                    if (idx == events.length) {
                        break;
                    }
                    continue;
                }
                // 取出今天参会的记录,结果+1
                int[] peek = queue.poll();
                res++;
                System.out.println("参加会议:");
                A.p(peek);
                // 当天结束的会议剔除.
                    System.out.println("结束会议:");
                while (!queue.isEmpty() && queue.peek()[1] == day) {
                    int[] poll = queue.poll();
                    A.p(poll);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new MaximumNumberOfEventsThatCanBeAttended().new Solution();
        int res = s.maxEvents(new int[][]{ new int[]{2, 3}, new int[]{3, 4},new int[]{1, 2},new int[]{1, 4},});
//        int res = s.maxEvents(new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}});
        System.out.println(res);

    }
}





























































