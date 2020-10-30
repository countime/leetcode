package leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode of(int... x) {
        ListNode s = new ListNode(0);
        ListNode end = s;
        for (int i : x) {
            ListNode e = new ListNode(i);
            end.next = e;
            end = e;
        }
        return s.next;
    }

    public static void p(ListNode l) {
        while (l != null) {
            System.out.print(l.val + ",");
            l = l.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String nextNode = next == null ? "" : next.toString();
        if (next == null) {
            return String.valueOf(val);
        }
        return val + "," + next.toString();
    }


    public static void main(String[] args) {
        System.out.println(ListNode.of(1,2,3));
    }
}