package com.xiongrj.algorithm.leetcode;

/**
 * @author 熊仁杰
 * @date 2020-06-11 11:14
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 两数相加 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean nextIn = false;
        ListNode nextListNode = l1;
        ListNode nextListNode2 = l2;

        ListNode listNode = new ListNode(0);
        ListNode topNode = listNode;
        ListNode preNode = null;
        while (nextListNode != null && nextListNode2 != null) {
            int sum = nextListNode.val + nextListNode2.val;
            if (nextIn) {
                sum += 1;
            }
            if (sum >= 10) {
                sum = sum % 10;
                nextIn = true;
            } else {
                nextIn = false;
            }
            listNode.val = sum;
            preNode = listNode;
            listNode.next = new ListNode(0);
            listNode = listNode.next;
            nextListNode = nextListNode.next;
            nextListNode2 = nextListNode2.next;
        }

        while (nextListNode != null) {
            if (nextIn) {
                int sum = nextListNode.val + 1;
                if (sum >= 10) {
                    sum = sum % 10;
                    nextIn = true;
                } else {
                    nextIn = false;
                }
                listNode.val = sum;
            } else {
                listNode.val = nextListNode.val;
            }
            nextListNode = nextListNode.next;
            preNode = listNode;
            listNode.next = new ListNode(0);
            listNode = listNode.next;
        }
        while (nextListNode2 != null) {
            if (nextIn) {
                int sum = nextListNode2.val + 1;
                if (sum >= 10) {
                    sum = sum % 10;
                    nextIn = true;
                } else {
                    nextIn = false;
                }
                listNode.val = sum;
            } else {
                listNode.val = nextListNode2.val;
            }
            nextListNode2 = nextListNode2.next;
            preNode = listNode;
            listNode.next = new ListNode(0);
            listNode = listNode.next;
        }

        if (nextIn) {
            listNode.val = 1;
        } else {
            preNode.next = null;
        }
        return topNode;
    }

}
