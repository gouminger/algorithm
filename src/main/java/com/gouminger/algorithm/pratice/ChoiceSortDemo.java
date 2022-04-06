package com.gouminger.algorithm.pratice;

import java.util.Arrays;

public class ChoiceSortDemo {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,6,9,4,5,8,7};
        //System.out.println(demo1(array, 3));
        demo2(array);
    }

    /**
     * 215. 数组中的第 K 个最大元素
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     */
    private static int demo1(int[] array, int k){
        for(int i=0;i<k;i++){//找出k个最大数字
            int index = 0;
            for(int j=1;j<array.length-i;j++){
                if(array[j] > array[index]){
                    index = j;
                }
            }
            if(index != array.length-1-i){
                array[index] = array[index]^array[array.length-1-i];
                array[array.length-1-i] = array[index]^array[array.length-1-i];
                array[index] = array[index]^array[array.length-1-i];
            }
        }
        return array[array.length-k];
    }

    /**
     * 912. 排序数组
     * 给你一个整数数组 nums，请你将该数组升序排列。
     */
    private static void demo2(int[] array){
        for(int i=0;i<array.length-1;i++){
            int index = 0;
            for(int j=1;j<array.length-i;j++){
                if(array[j] > array[index]){
                    index = j;
                }
            }
            if(index != array.length-1-i){
                array[index] = array[index]^array[array.length-1-i];
                array[array.length-1-i] = array[index]^array[array.length-1-i];
                array[index] = array[index]^array[array.length-1-i];
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
