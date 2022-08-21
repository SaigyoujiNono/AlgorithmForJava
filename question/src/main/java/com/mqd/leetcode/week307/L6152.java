package com.mqd.leetcode.week307;

/**
 * leetcode 6152. 赢得比赛需要的最少训练时长
 * 你正在参加一场比赛，给你两个 正 整数 initialEnergy 和 initialExperience 分别表示你的初始精力和初始经验。
 *
 * 另给你两个下标从 0 开始的整数数组 energy 和 experience，长度均为 n 。
 *
 * 你将会 依次 对上 n 个对手。第 i 个对手的精力和经验分别用 energy[i] 和 experience[i] 表示。
 * 当你对上对手时，需要在经验和精力上都 严格 超过对手才能击败他们，然后在可能的情况下继续对上下一个对手。
 *
 * 击败第 i 个对手会使你的经验 增加 experience[i]，但会将你的精力 减少  energy[i] 。
 *
 * 在开始比赛前，你可以训练几个小时。每训练一个小时，你可以选择将增加经验增加 1 或者 将精力增加 1 。
 *
 * 返回击败全部 n 个对手需要训练的 最少 小时数目。
 */
public class L6152 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[] t1 = {1,2};
        int[] t2 = {2,5};
        int energy = 5;
        int exp = 3;
//        int[] t1 = {1,4,3,2};
//        int[] t2 = {2,6,3,1};
//        int energy = 5;
//        int exp = 3;
        System.out.println(p.minNumberOfHours(energy, exp, t1, t2));
    }

    static class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int vital = initialEnergy;
            int exp = initialExperience;
            int ans = 0;
            for (int i = 0; i < energy.length; i++) {
                if (vital <= energy[i] && exp <= experience[i]) {
                    int tv = (energy[i] - vital + 1);
                    vital += tv;
                    int te = (experience[i] - exp + 1);
                    exp += te;
                    ans += (te + tv);
                } else if (vital <= energy[i]) {
                    int tv = (energy[i] - vital + 1);
                    vital += tv;
                    ans += tv;
                } else if (exp <= experience[i]){
                    int te = (experience[i] - exp + 1);
                    exp += te;
                    ans += te;
                }
                vital -= energy[i];
                exp += experience[i];
            }
            return ans;
        }
    }
}
