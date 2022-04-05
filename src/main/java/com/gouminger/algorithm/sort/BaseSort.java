package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class BaseSort {

    /**
     * 基数排序，将数字按数位拆分比较
     * 时间排序O(n)
     * 空间排序O(n)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,31,116,9,14,8,7,15};
        int maxNumber = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]>maxNumber){
                maxNumber = array[i];
            }
        }
        int maxLength = Integer.toString(maxNumber).length();
        int dev = 1;
        for(int i=0;i<maxLength;i++){
            int[] countArray = new int[10];
            int[] result = new int[array.length];
            for(int j=0;j<array.length;j++){
                int value = (array[j]/(dev))%10;
                countArray[value]++;
            }
            for(int k=1;k<countArray.length;k++){
                countArray[k] = countArray[k]+countArray[k-1];
            }
            for(int l=array.length-1;l>=0;l--){
                int value = (array[l]/(dev))%10;
                result[--countArray[value]] = array[l];
            }
            System.arraycopy(result, 0, array, 0, array.length);
            dev *= 10;
        }
        System.out.println(Arrays.toString(array));
    }

}
