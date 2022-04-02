package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序，每次选一个基数，将比他小的放到左端，大的放到右端；依次对左边数组部分和右边数组部分重复操作
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end){
        if(end-start<=0){
            return;
        }
        int standard = sortStandard(array, start, end);
        quickSort(array, start, standard-1);
        quickSort(array, standard+1, end);
    }

    private static int sortStandard(int[] array, int start, int end){
        int standard = start;
        int rightSize = 0;
        for(int i=start+1;i<=end-rightSize;i++){
            if(array[standard] > array[i]){
                array[i] = array[i]^array[standard];
                array[standard] = array[i]^array[standard];
                array[i] = array[i]^array[standard];
                standard = i;
            }else if(array[standard] < array[i]){
                if(i == end - rightSize){
                    continue;
                }
                array[i] = array[i]^array[end-rightSize];
                array[end-rightSize] = array[i]^array[end-rightSize];
                array[i] = array[i]^array[end-rightSize];
                rightSize++;
                i--;
            }
        }
        return standard;
    }

}
