package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    /**
     * 堆排序，采用堆结构记录数据，每次将堆定元素交换至末尾，然后修正，重复过程
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        buildHeap(array, array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array, 0, array.length-1-i);
            buildHeap(array, array.length-1-i);
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 最后一个根结点下标为2n-1
     * 下标为n的元素的左节点为2n+1；右节点为2n+2
     */
    private static void buildHeap(int[] array, int length){
        for(int i=length/2-1;i>=0;i--){
            updateHeap(array, i, length);
        }
    }

    private static void updateHeap(int[] array, int i, int length){
        int index = i;
        if(2*i+1 < length && array[2*i+1] > array[index]){
            index = 2*i+1;
        }
        if(2*i+2 < length && array[2*i+2] > array[index]){
            index = 2*i+2;
        }
        if(index != i){
            swap(array, i, index);
            updateHeap(array, index, length);
        }
    }

    private static void swap (int[] array, int left, int right){
        array[left] = array[left]^array[right];
        array[right] = array[left]^array[right];
        array[left] = array[left]^array[right];
    }

}
