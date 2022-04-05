package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class HillSort {

    /**
     * 希尔排序，消除逆序对的思想，冒泡，选择，插入排序都是比较相邻元素来消除逆序对，对于一个随机数组，他的逆序对是n²，
     * 因此这三种的时间复杂度都是n²。希尔排序通过间隔分组，比较子数组相邻元素减少间隔数量的逆序对来突破时间复杂度的n²。
     * 首先根据n/2的间隔分组，每次分组间隔都是上次的一半。排序每个分组，最后间隔为1时就是整体有序
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     */
    public static void main(String[] args) {
        int[] array = new int[]{5,1,1,2,0,0};
        hillSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void hillSort(int[] array){
        for(int step= array.length/2;step>0;step = step/2){
            for(int i=0;i<array.length;i++){
                int numberIndex = i;
                for (int nextIndex = i+step;nextIndex<array.length;nextIndex+=step){
                    if(array[numberIndex] > array[nextIndex]){
                        numberIndex = nextIndex;
                    }
                }
                if(numberIndex != i){
                    array[numberIndex] = array[numberIndex]^array[i];
                    array[i] = array[numberIndex]^array[i];
                    array[numberIndex] = array[numberIndex]^array[i];
                }
            }
        }
    }

}
