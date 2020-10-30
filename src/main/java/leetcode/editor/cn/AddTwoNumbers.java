//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4788 👎 0


package leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicInteger;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        System.out.println(solution.addTwoNumbers(L.of(2, 4, 3),
                L.of(5, 6, 4)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            AtomicInteger lower = new AtomicInteger(0);
            ListNode listNode = new ListNode(0);
            add(l1, l2, listNode, lower);
            return listNode;
        }

        private void add(ListNode l1, ListNode l2, ListNode l, AtomicInteger lower) {
            if (l1 == null && l2 == null && lower.get() == 0) {
                return;
            }
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + lower.get();
            l.val = sum % 10;
            lower.set(sum / 10);
            if ((l1 != null && l1.next != null) ||
                    (l2 != null && l2.next != null) || lower.get() != 0) {
                ListNode next = new ListNode(0);
                l.next = next;
                add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, next, lower);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
