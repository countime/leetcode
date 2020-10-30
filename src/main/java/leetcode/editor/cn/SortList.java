package leetcode.editor.cn;
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 788 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class SortList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            int cnt = 0;
            ListNode tmp = head;
            while (tmp != null) {
                cnt++;
                tmp = tmp.next;
            }
            if (cnt < 2) {
                return head;
            }

            ListNode[] arr = new ListNode[cnt];
            int idx = 0;
            while (head != null) {
                ListNode tmp2 = head;
                head = head.next;
                arr[idx++] = tmp2;
            }
            Arrays.sort(arr, Comparator.comparingInt(e -> e.val));

            ListNode res = arr[0];
            ListNode last = arr[0];
            for (int i = 1; i < arr.length; i++) {
                last.next = arr[i];
                last = last.next;
            }
            last.next = null;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SortList().new Solution();
        ListNode res = s.sortList(ListNode.of(4, 2, 1, 3));
        System.out.println(res);
    }
}