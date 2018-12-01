package medium;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LC19_RemoveNthNodeFromEndOfList
 * @Description: 删除链表的倒数第N个节点,
 * @Author: 余佳东
 * @Date: 2018-12-01 10:51
 * @Version: V1.0
 **/
public class LC19_RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 16 ms, 在Remove Nth Node From End of List的Java提交中击败了43.44% 的用户
     * @Param: [head, n]
     * @Return: medium.LC19_RemoveNthNodeFromEndOfList.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();

        ListNode tmp = head;
        // System.out.println(tmp.next.val);

        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }

        if (n >= list.size()) {
            return head.next;
        }

        ListNode front = list.get(list.size() - n -1);

        if(front.next.next == null) {
            front.next = null;
        } else {
            front.next = front.next.next;
        }

        return head;
    }

    /**
     * @Description: 两个指针法。一次遍历, 9 ms, 在Remove Nth Node From End of List的Java提交中击败了96.16% 的用户
     * @Param: [head, n]
     * @Return: medium.LC19_RemoveNthNodeFromEndOfList.ListNode
     */
    public ListNode removeNthFromEndBest(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();

        ListNode tmp = head;
        ListNode slow = head;
        ListNode remove = head;

        int i = 1;
        while (tmp != null) {
            i++;
            list.add(tmp);
            tmp = tmp.next;

            if (i > n + 1) {
                remove = remove.next;
            }

            if (i > n + 2) {
                slow = slow.next;
            }
        }

        if (remove == head) {
            return head.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    /**
     * @Description: 打印链表
     * @Param: [head]
     * @Return: void
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    /**
     * @Description:
     * @Param: [args]
     * @Return: void
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(new LC19_RemoveNthNodeFromEndOfList().removeNthFromEndBest(head, 2));
    }
}
