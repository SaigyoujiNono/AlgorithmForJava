package com.mqd;

/**
 * 暂未解决
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1};
        System.out.println(solution(arr,0,0));
    }

    public static int solution(int[] arr, int start, int res){
        if(start == arr.length){
            return res;
        }
        return Math.max(solution(arr, start + 1,res),
                solution(arr, start + 1,res+arr[start])
        );
    }
}
