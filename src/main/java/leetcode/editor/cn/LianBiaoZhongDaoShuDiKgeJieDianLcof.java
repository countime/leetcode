package leetcode.editor.cn;
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 90 👎 0

public class LianBiaoZhongDaoShuDiKgeJieDianLcof{
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        return getKthFromEnd1(head, k);
    }
    //先算总数
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        if (k > count) {
            return null;
        }

        cur=head;
        for (int i = 0; i < count-k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //步差指针.
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow=slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        System.out.println(s.getKthFromEnd(ListNode.of(1, 2, 3), 1));
    }
}