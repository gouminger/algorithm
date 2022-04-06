package com.gouminger.algorithm.pratice;

import java.util.Arrays;

public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] array = new int[]{2,5,6,0,0,0,8,9,3,4,7};
        //System.out.println(demo1(array));
        demo2(array);
    }

    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    private static String demo1(int[] array){
        for(int i=0;i<array.length-1;i++){//需要排序n-1个数字
            for(int j=0;j<array.length-1-i;j++){
                if((array[j]+""+array[j+1]).compareTo((array[j+1]+""+array[j])) > 0){
                    array[j] = array[j]^array[j+1];
                    array[j+1] = array[j]^array[j+1];
                    array[j] = array[j]^array[j+1];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(array.length);
        for(int child : array){
            stringBuilder.append(child);
        }
        return stringBuilder.toString();
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    private static void demo2(int[] array){
        int index = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == 0){
                continue;
            }
            if(i<=index){
                index++;
            }else{
                array[index++] = array[i];
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
