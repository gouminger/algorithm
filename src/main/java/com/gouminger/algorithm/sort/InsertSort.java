package com.gouminger.algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    /**
     * 插入排序，将第一个之后的数字与前面数字比较插入正确的顺序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,9,4,8,7,5};
        method2(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 新插入的数字不断与前面的数字比较，小于则交换
     */
    private static void method1(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j-1] > array[j]){
                    array[j-1] = array[j-1]^array[j];
                    array[j] = array[j-1]^array[j];
                    array[j-1] = array[j-1]^array[j];
                }else{
                    break;
                }
            }
        }
    }

    private static void method2(int[] array){
        int index,num;
        for(int i=1;i<array.length;i++){
            index = i;
            num = array[i];
            for(int j=i;j>0;j--){
                if(array[j-1] > num){
                    index = j-1;
                    array[j] = array[j-1];
                }else{
                    break;
                }
            }
            array[index] = num;
        }
    }

}
