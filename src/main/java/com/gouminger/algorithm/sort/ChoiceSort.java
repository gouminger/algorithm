package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class ChoiceSort {

    /**
     * 选择排序，每次循环找出一个最值的下标，然后交换值一端，需要循环数组长度的次数
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        method2(array);
        System.out.println(Arrays.toString(array));
    }

    private static void method1 (int[] array){
        int smallIndex = 0;
        for(int i=0;i<array.length-1;i++){
            smallIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[smallIndex] > array[j]){
                    smallIndex = j;
                }
            }
            if(smallIndex != i){
                array[smallIndex] = array[smallIndex]^array[i];
                array[i] = array[smallIndex]^array[i];
                array[smallIndex] = array[smallIndex]^array[i];
            }
        }
    }

    /**
     * 二元选择排序，每次找出最大最小两个值
     */
    private static void method2(int[] array){
        int smallIndex, bigIndex;
        for(int i=0;i<array.length/2;i++){
            smallIndex = i;
            bigIndex = array.length-1-i;
            for(int j=i;j<=array.length-1-i;j++){
                if(array[smallIndex] > array[j]){
                    smallIndex = j;
                }
                if(array[bigIndex] < array[j]){
                    bigIndex = j;
                }
            }
            if(smallIndex != i){
                array[smallIndex] = array[smallIndex]^array[i];
                array[i] = array[smallIndex]^array[i];
                array[smallIndex] = array[smallIndex]^array[i];
            }
            if(smallIndex == array.length-1-i){
                continue;
            }
            if(bigIndex != array.length-1-i){
                array[bigIndex] = array[bigIndex]^array[array.length-1-i];
                array[array.length-1-i] = array[bigIndex]^array[array.length-1-i];
                array[bigIndex] = array[bigIndex]^array[array.length-1-i];
            }
        }
    }

}
