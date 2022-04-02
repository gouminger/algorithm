package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    /**
     * 合并排序，第一步将数组二分拆分至单个元素的数组；第二步将单元素数组作为有序数组两两合并
     * 时间复杂度O(nlogn)
     * 空间复杂度O(nlogn,n,1)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        int[] result = method1(array);
        System.out.println(Arrays.toString(result));
    }

    private static int[] method1(int[] array){
        return splitArray1(array, 0, array.length-1);
    }

    private static int[] splitArray1(int[] array, int start, int end){
        if(start==end){
            return new int[]{array[start]};
        }
        return mergeArray1(splitArray1(array, start, (start+end)/2), splitArray1(array, (start+end)/2+1, end));
    }


    private static int[] mergeArray1(int[] leftArray, int[] rightArray){
        int[] result = new int[leftArray.length+rightArray.length];
        int i=0,j=0;
        for(;i<leftArray.length && j<rightArray.length;){
            if(leftArray[i] <= rightArray[j]){
                result[i+j] = leftArray[i++];
            }else{
                result[i+j] = rightArray[j++];
            }
        }
        while(i<leftArray.length){
            result[i+j] = leftArray[i++];
        }
        while(j<rightArray.length){
            result[i+j] = rightArray[j++];
        }
        return result;
    }

}
