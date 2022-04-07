package com.gouminger.algorithm.pratice;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class InsertSortDemo {

    public static void main(String[] args) {
//        int[] array = new int[]{2,3,1,6,9,4,5,8,7};
//        demo1(array);

        ListNode listNode5 = new ListNode(4);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(1, listNode4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode = new ListNode(-1, listNode2);

        ListNode result = new ListNode(-5000);
        demo2(listNode, result);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }



    }

    /**
     * 912. 排序数组
     * 给你一个整数数组 nums，请你将该数组升序排列。
     */
    private static void demo1(int[] array){
        for(int i=1;i<array.length;i++){
            int index=i;
            int num = array[index];
            for(int j=i-1;j>=0;j--){
                if(num < array[j]){
                    array[index]=array[j];
                    index=j;
                }else{
                    break;
                }
            }
            array[index]=num;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 147. 对链表进行插入排序
     * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
     *
     * 插入排序 算法的步骤:
     *
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
     *
     * 对链表进行插入排序。
     */
    private static void demo2(ListNode listNode, ListNode result){
        if(listNode == null){
            return;
        }
        ListNode nextListNode = listNode.next;
        listNode.next = null;
        addNode(result, listNode);
        demo2(nextListNode, result);
    }

    private static void addNode(ListNode result, ListNode childNode){
        if(result.val >= childNode.val){
            childNode.next = result;
        }else if(result.next == null){
            result.next = childNode;
        }else if(result.val < childNode.val && childNode.val <= result.next.val){
            childNode.next = result.next;
            result.next = childNode;
        }else{
            addNode(result.next, childNode);
        }
    }

}
