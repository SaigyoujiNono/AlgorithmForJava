package com.mqd;


/**
 * 选择数字游戏
 * 设有一组数字
 * A先选 B后选
 * 每次只能从最左或者最右选择一个数字
 * 求谁一定赢
 */
public class SelectNumberGame {

    public static void main(String[] args) {
        int[] arr = {2,3,100,50,8,15,85,66,17,28,39,46,25};
        System.out.println(first(arr, 0, arr.length - 1));
        System.out.println(second(arr, 0, arr.length - 1));
        win2(arr);
    }

    /**
     * 先手函数
     * @param arr   数组
     * @param start 开始下标
     * @param end   结束下标
     * @return  最优结果
     */
    public static int first(int[] arr,int start,int end){
        if (start == end){
            return arr[start];
        }
        return Math.max(arr[start]+second(arr,start+1,end),
                arr[end]+second(arr,start,end-1));
    }


    public static int second(int[] arr,int start,int end){
        if (start == end){
            return 0;
        }
        return Math.min(first(arr,start+1,end),
                first(arr,start,end-1));
    }

    public static int win2(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] first = new int[arr.length][arr.length];
        int[][] second = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            first[i][i] = arr[i];
            for (int j = i-1; j >= 0; j--) {
                first[j][i] = Math.max(arr[j]+second[j+1][i],arr[i]+second[j][i-1]);
                second[j][i] = Math.min(first[j+1][i],first[j][i-1]);
            }
        }
        System.out.println(first[0][arr.length-1]+" "+second[0][arr.length-1]);
        return Math.max(first[0][arr.length-1],second[0][arr.length-1]);
    }
}
