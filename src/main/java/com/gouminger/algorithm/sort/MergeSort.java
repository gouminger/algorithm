package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    /**
     * 合并排序，第一步将数组二分拆分至单个元素的数组；第二步将单元素数组作为有序数组两两合并
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        method2(array);
    }

    private static void method1(int[] array){
        int[] result = splitArray1(array, 0, array.length-1);
        System.out.println(Arrays.toString(result));
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

    private static void method2(int[] array){
        int[] result = new int[array.length];
        splitArray2(array, 0, array.length-1, result);
        System.out.println(Arrays.toString(result));
    }

    private static void splitArray2(int[] array, int start, int end, int[] result){
        if(start==end){
            return;
        }
        splitArray2(array, start, (start+end)/2, result);
        splitArray2(array, (start+end)/2+1, end, result);
        mergeArray2(array, start, end, result);
    }

    private static void mergeArray2(int[] array, int start, int end, int[] result){
        int medium = (start+end)/2;
        int i=start,j=medium+1,index=start;
        for(;i<=medium && j<=end;){
            if(array[i] <= array[j]){
                result[index++] = array[i++];
            }else{
                result[index++] = array[j++];
            }
        }
        while(i<=medium){
            result[index++] = array[i++];
        }
        while(j<=end){
            result[index++] = array[j++];
        }
        for(int swapIndex=start;swapIndex<=end;swapIndex++){
            array[swapIndex] = result[swapIndex];
        }
    }

}
