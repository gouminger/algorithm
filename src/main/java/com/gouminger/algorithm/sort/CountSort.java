package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class CountSort {

    /**
     * 计数排序，用于在数值大小在一定范围的随机数组排序
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,6,4,8,7,5};
        Integer[] countArray = new Integer[10];
        for(int child : array){
            if(countArray[child] == null){
                countArray[child] = 0;
            }
            countArray[child]++;
        }
        System.out.println(Arrays.toString(countArray));
        int countIndex=0;
        for(int i=0;i<countArray.length;i++){
            if(countArray[i] == null){
                continue;
            }
            int count = countArray[i];
            countArray[i] = countIndex;
            countIndex+=count;
        }
        System.out.println(Arrays.toString(countArray));
        int[] result = new int[array.length];
        for(int i=0;i<array.length;i++){
            int index = countArray[array[i]];
            result[index] = array[i];
            countArray[array[i]]++;
        }
//        for(int i=0;i<countArray.length;i++){
//            if(countArray[i] == null){
//                continue;
//            }
//            while (countArray[i]>0){
//                array[index++] = i;
//                countArray[i]--;
//            }
//        }
        System.out.println(Arrays.toString(result));
    }

}
