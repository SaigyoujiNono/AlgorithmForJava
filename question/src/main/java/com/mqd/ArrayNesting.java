package com.mqd;

import com.mqd.utils.RandomArrayBuilder;

import java.util.*;

/**
 * 数组嵌套
 * 一个长为 N 且下标从 0 开始的数组 A 包含 从 0 到 N - 1 的所有整数。
 * 找到并返回集合 S 的最大长度，其中S [i] = {A [i]，A [A [i]]，A [A [A [i]]]，...}受到以下规则的约束。
 *
 * 假设 S 中的第一个元素以选择 index = i的元素A [i]开始，S中的下一个元素应该是A [A [i]]，然后是A [A [A [i]]] ...
 * 通过这个类比，我们在S中出现重复元素之前就停止添加。
 * 输入: [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一个最长的S [K]：
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class ArrayNesting {

    public static void main(String[] args) {
        int[] arr1 = {5,4,0,3,1,6,2};
        int[] arr2 = RandomArrayBuilder.randomArray(0,100000000);
//        int[] arr3 = {1,0,4,2,3,7,5,6};
        int[] input;
        input = arr2;
        long t1 = System.currentTimeMillis();
//        System.out.println(solution(input));
        long t2 = System.currentTimeMillis();
//        System.out.println(solution2(input));
        long t3 = System.currentTimeMillis();
//        System.out.println(solution3(input));
        long t4 = System.currentTimeMillis();
        System.out.println(solution4(input));
        long t5 = System.currentTimeMillis();
        System.out.println("solution: "+(t2-t1)+"ms");
        System.out.println("solution2: "+(t3-t2)+"ms");
        System.out.println("solution3: "+(t4-t3)+"ms");
        System.out.println("solution3: "+(t4-t3)+"ms");
        System.out.println("solution4: "+(t5-t4)+"ms");
    }
    public static int solution(int[] nums){
        int res = 0;
        for (int num : nums) {
            Map<Integer,Integer> temp = new HashMap<>();
            int t = num;
            while (!temp.containsKey(t)){
                temp.put(t,nums[t]);
                t = nums[t];
            }
            res = Math.max(res,temp.size());
        }
        return res;
    }

    public static int solution2(int[] nums){
        int res = 0;
        for (int num : nums) {
            Set<Integer> temp = new HashSet<>();
            int t = num;
            while (!temp.contains(t)){
                temp.add(t);
                t = nums[t];
            }
            res = Math.max(res,temp.size());
        }
        return res;
    }

    public static int solution3(int[] nums){
        int[] arr = new int[nums.length];

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(arr, 0);
            int t = nums[i];
            arr[i] = 1;
            int count = 1;
            while (arr[t]==0){
                arr[t] = 1;
                t = nums[t];
                count++;
            }
            res = Math.max(res,count);
        }
        return res;
    }

    /**
     * 别人的方法
     * @param nums  数组
     * @return  最大列长度
     */
    public static int solution4(int[] nums){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1){
                continue;
            }
            int count = 0;
            int index = i;
            while(nums[index] != -1){
                //System.out.println(index);
                int temp = nums[index];
                nums[index] = -1;
                index = temp;

                count++;
            }

            res = Math.max(count, res);
        }
        return res;
    }
}
