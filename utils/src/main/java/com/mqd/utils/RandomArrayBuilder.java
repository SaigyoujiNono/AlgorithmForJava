package com.mqd.utils;

import java.util.Random;

/**
 * 随机数组创建
 */
public class RandomArrayBuilder {
    private static final Random random = new Random(System.currentTimeMillis());

    //创建一个顺序数组
    private static int[] createArray(int min,int max){
        int[] tempArr = new int[max+1-min];
        for (int i = min,j=0; i < max+1; i++,j++) {
            tempArr[j] = i;
        }
        return tempArr;
    }

    //将一个数组打乱
    private static void shuffle(int[] arr){
        int temp;
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = randomInt(i+1, arr.length-1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 返回一个连续的随机数组
     * @param min   数组最小值
     * @param max   数组最大值
     * @return  返回一个随机数组
     */
    public static int[] randomArray(int min, int max){
        int[] arr = createArray(min,max);
        shuffle(arr);
        return arr;
    }

    /**
     * 生成一个不连续的随机数组
     * @param min   最小值
     * @param max   最大值
     * @param len   长度
     * @return  返回一个随机数组
     */
    public static int[] randomArray(int min, int max, int len) {
        if (len > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[len];

        for (int i = 0; i < result.length; i++) {
            int num = randomInt(min, max);
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                i--;
            } else {
                result[i] = num;
            }
        }
        return result;
    }

    //生产一个随机数
    public static int randomInt(int min, int max) {
        if (min == max){
            return max;
        }
        if (max < min){
            return 0;
        }
        return random.nextInt(max-min+1)+min;
    }

}
