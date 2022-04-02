package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序
     * 最简单的排序，依次比较相邻的两个值，将最大或最小的放在左端，每次循环都可以将一个最值放在左端
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        method4(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 原始写法
     */
    private static void method1(int[] array){
        for(int i=0;i<array.length-1;i++){//总共排序array.length-1个数
            for(int j=0;j<array.length-1-i;j++){//每次循环长度减1
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 第一次优化，如果当前轮次没有发生交换，说明全部排序完成。
     */
    private static void method2(int[] array){
        boolean swap = true;
        int times = 0;
        while(swap){
            swap = false;
            for(int i=0;i<array.length-1-times;i++){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swap = true;
                }
            }
            times++;
        }
    }

    /**
     * 第二次优化，每次循环中最后一次交换的位置之后的数已经按照规则排好序，下一次可根据最后一次交换位置节点作为结束点。
     */
    private static void method3(int[] array){
        boolean swap = true;
        int lastSwapIndex = array.length-1;
        int curSwapIndex = 0;
        while (swap){
            swap = false;
            for(int i=0;i<lastSwapIndex;i++){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swap = true;
                    curSwapIndex = i;
                    swap = true;
                }
            }
            lastSwapIndex = curSwapIndex;
        }
    }

    /**
     * 第三次优化，交换数字时根据异或可减少空间复杂度
     */
    private static void method4(int[] array){
        boolean swap = true;
        int lastSwapIndex = array.length-1;
        int curSwapIndex = 0;
        while (swap){
            swap = false;
            for(int i=0;i<lastSwapIndex;i++){
                if(array[i] > array[i+1]){
                    array[i] = array[i]^array[i+1];
                    array[i+1] = array[i]^array[i+1];
                    array[i] = array[i]^array[i+1];
                    swap = true;
                    curSwapIndex = i;
                }
            }
            lastSwapIndex = curSwapIndex;
        }
    }

}
