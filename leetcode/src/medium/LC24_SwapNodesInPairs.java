package medium;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

/**
 * @ClassName: LC24_SwapNodesInPairs
 * @Description: 两两交换链表中的节点
 * @Author: 余佳东
 * @Date: 2018-12-06 09:52
 * @Version: V1.0
 **/
public class LC24_SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 5 ms, 在Swap Nodes in Pairs的Java提交中击败了39.43% 的用户
     * @Param: [head]
     * @Return: medium.LC24_SwapNodesInPairs.ListNode
     */
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode headResult = head.next;
        ListNode last = null;

        while (head != null && head.next != null) {
            ListNode tmp = head.next;
            head.next = head.next.next;
            tmp.next = head;

            if (last != null) {
                last.next = tmp;
            }

            last = tmp.next;
            head = head.next;
        }

        return headResult;
    }

    /**
     * @Description: 打印链表
     * @Param: [head]
     * @Return: void
     */
    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode();

        LC24_SwapNodesInPairs test = new LC24_SwapNodesInPairs();
        test.printList(test.swapPairs(head));
    }
}
