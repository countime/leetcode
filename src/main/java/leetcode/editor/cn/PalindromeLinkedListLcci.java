package leetcode.editor.cn;
//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 31 👎 0

public class PalindromeLinkedListLcci{
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // 反转前半段.
        while (fast != null && fast.next != null) {
            ListNode tmp = slow;
            slow = slow.next;
            fast = fast.next.next;

            tmp.next=prev;
            prev=tmp;
        }

        // 基数
        if (fast != null) {
            slow = slow.next;
        }

        while (slow!=null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow=slow.next;
            prev=prev.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new PalindromeLinkedListLcci().new Solution();
//        System.out.println(s.isPalindrome(ListNode.of(1, 2, 3)));
        System.out.println(s.isPalindrome(ListNode.of(1, 2, 3,3, 2, 1)));
    }
}