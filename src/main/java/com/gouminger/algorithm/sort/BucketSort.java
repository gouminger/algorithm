package com.gouminger.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class BucketSort {

    /**
     * 桶排序，划分多个桶，将数组拆分至对应桶中，桶内排序，然后合并
     * 时间排序O(n)
     * 空间排序O(n)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,31,16,9,14,8,7,15};
        int minValue = array[0];
        int maxValue = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i] > maxValue){
                maxValue = array[i];
            }
            if(array[i] < minValue){
                minValue = array[i];
            }
        }
        int range = maxValue-minValue;
        int bucketNum = 5;
        int bucketSize = range/(bucketNum-1);
        int[][] bucketArray = new int[bucketNum][array.length];
        int[] bucketIndexArray = new int[bucketNum];
        for(int i=0;i<array.length;i++){
            int bucketIndex = (array[i]-minValue)/bucketSize;
            bucketArray[bucketIndex][bucketIndexArray[bucketIndex]++] = array[i];
        }
        int index = 0;
        for(int i=0;i<bucketIndexArray.length;i++){
            if(bucketIndexArray[i]<=0){
                continue;
            }
            sortChild(bucketArray[i], bucketIndexArray[i]);
            for(int j=0;j<bucketIndexArray[i];j++){
                array[index++] = bucketArray[i][j];
            }
        }
        System.out.println(JSON.toJSON(array));
    }

    private static void sortChild(int[] childArray, int length){
        for(int i=0;i<length-1;i++){
            int index = 0;
            for(int j=0;j<length-i;j++){
                if(childArray[j]>childArray[index]){
                    index=j;
                }
            }
            if(index != length-1-i){
                childArray[index] = childArray[index]^childArray[length-1-i];
                childArray[length-1-i] = childArray[index]^childArray[length-1-i];
                childArray[index] = childArray[index]^childArray[length-1-i];
            }
        }
    }

}
