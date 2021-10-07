package com.mqd.conference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 会议问题
 * 假设一天24小时
 * 每个会议有开始时间和结束时间
 * 根据策略选择安排最优策略
 */

public class Program {
    /**
     * 比较器
     * 根据会议结束时间来比较大小
     * o1<o2返回负数
     * @param cons  会议列表
     * @param timePoint 时间点
     * @return 可以安排会议的场次
     */
    public static int bestArrangeByEnd(Conference[] cons, int timePoint){
        //先对会议的结束时间进行排序
        Arrays.sort(cons, Comparator.comparingInt(o -> o.end));
        //结果: 最终可以安排多少场会议
        int result = 0;
        for (Conference con : cons) {
            if (timePoint<=con.start){
                result++;
                timePoint = con.end;
            }
        }
        return result;
    }

    /**
     * 会议
     * start为开始时间
     * end为结束时间
     */
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Conference{
        private int start;
        private int end;
    }
}
