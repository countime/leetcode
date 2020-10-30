package leetcode.editor.cn;
//给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,5,4], k = 1
//输出：1
//解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
// 
//
// 示例 2： 
//
// 输入：arr = [4,3,1,1,3,3,2], k = 3
//输出：2
//解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 10^9 
// 0 <= k <= arr.length 
// 
// Related Topics 排序 数组 
// 👍 17 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeastNumberOfUniqueIntegersAfterKRemovals{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //使用优先队列,好处是不用完全的排序.
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(map.values());

//        A.p(list);
        int leftCnt = map.size();
        while (true) {
            if (k == 0) {
                return leftCnt;
            } else if (k > 0) {
                k = k - queue.poll();
                leftCnt--;
            } else {
                return leftCnt+1;
            }
        }
    }

        public int findLeastNumOfUniqueInts2(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int e : arr) {
                map.put(e, map.getOrDefault(e, 0) + 1);
            }
            Stream<Integer> sorted = map.values().stream().sorted();
            List<Integer> list = sorted.collect(Collectors.toList());
//        A.p(list);
            int idx = 0;
            int leftCnt = map.size();
            while (true) {
                if (k == 0) {
                    return leftCnt;
                } else if (k > 0) {
                    k = k - list.get(idx++);
                    leftCnt--;
                } else {
                    return leftCnt+1;
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new LeastNumberOfUniqueIntegersAfterKRemovals().new Solution();
        int res = s.findLeastNumOfUniqueInts(new int[]{1, 2, 1,3,4}, 3);
        System.out.println(res);
    }
}





























































