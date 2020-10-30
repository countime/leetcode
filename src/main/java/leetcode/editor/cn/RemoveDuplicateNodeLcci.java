package leetcode.editor.cn;
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 69 👎 0

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {
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
        public ListNode removeDuplicateNodes(ListNode head) {
            return removeDuplicateNodes2(head);
        }
            // 哨兵可以解决入参为null,边界问题
        public ListNode removeDuplicateNodes1(ListNode head) {
            ListNode sent = new ListNode(0);
            sent.next = head;

            Set<Integer> set = new HashSet<>();
            ListNode end = sent;
            ListNode curr = head;
            while (curr != null) {
                if (!set.contains(curr.val)) {
                    end.next = curr;
                    end = curr;
                    set.add(curr.val);
                }
                curr = curr.next;
            }
            end.next = null;
            return sent.next;
        }

        //两层变量移除重复数据
        public ListNode removeDuplicateNodes2(ListNode head) {
            ListNode curr1 = head;
            while (curr1 != null) {
                ListNode curr2 = curr1;
                while (curr2.next != null) {
                    if (curr2.next.val == curr1.val) {
                        curr2.next = curr2.next.next;
                    } else {
                        curr2 = curr2.next;
                    }
                }
                curr1 = curr1.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new RemoveDuplicateNodeLcci().new Solution();
        ListNode listNode = s.removeDuplicateNodes(ListNode.of(1, 2, 3, 3, 2, 1));
//        ListNode listNode = s.removeDuplicateNodes(ListNode.of(1, 1, 1, 1));
//        ListNode listNode = s.removeDuplicateNodes(null);
        System.out.println(listNode);
    }
}