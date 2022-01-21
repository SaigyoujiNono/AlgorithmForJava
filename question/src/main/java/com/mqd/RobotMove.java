package com.mqd;

/**
 * 机器人移动问题
 * 设有一个正整数序列为[1..n]
 * s为机器人起步的位置 s∈[1...n]
 * e为机器人的终点位置 e∈[1...n]
 * k为机器人必须走的步数
 * 求一共有多少种走法
 */
public class RobotMove {
    public static void main(String[] args) {
        int n=21,s=14,e=18,k=36;
        RobotMove robotMove = new RobotMove();
        long t1 = System.currentTimeMillis();
        System.out.println(robotMove.solution(n,s,e,k));
        long t2 = System.currentTimeMillis();
        System.out.println("耗时:"+(t2-t1)+"ms");
        System.out.println(robotMove.solution2(n,s,e,k));
        long t3 = System.currentTimeMillis();
        System.out.println("耗时:"+(t3-t2)+"ms");
        System.out.println(robotMove.solution3(n,s,e,k));
        long t4 = System.currentTimeMillis();
        System.out.println("耗时:"+(t4-t3)+"ms");
    }
    /**
     * @return  走法数量
     */
    public int solution(int n,int s,int e,int k){
        if (n<1 || Math.abs(e-s)>k || (s==e && k%2!=0)
                || (Math.abs(e-s)%2==0 && k%2!=0) || (Math.abs(e-s)%2!=0 && k%2==0)
                || s>n || s<1 || e>n || e<1){
            return 0;
        }
        if (k==0 && s == e){
            return 1;
        }
        return solution(n,s+1,e,k-1)+solution(n,s-1,e,k-1);
    }

    /**
     * 记忆化搜索
     */
    public int solution2(int n,int s,int e,int k){
        int[][] record = new int[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                record[s][k] = -1;
            }
        }
        return solution2f(n,s,e,k,record);
    }

    /**
     * 记忆化搜索
     * @return  走法数量
     */
    public int solution2f(int n,int s,int e,int k,int[][] record){
        if (record[s][k]!=-1){
            return record[s][k];
        }
        if (n<1 || Math.abs(e-s)>k || (s==e && k%2!=0)
                || (Math.abs(e-s)%2==0 && k%2!=0) || (Math.abs(e-s)%2!=0 && k%2==0)
                || s>n || s<1 || e>n || e<1){
            record[s][k] = 0;
            return 0;
        }
        if (k==0 && s == e){
            record[s][k] = 1;
            return 1;
        }
        record[s][k] = solution(n,s+1,e,k-1)+solution(n,s-1,e,k-1);
        return record[s][k];
    }

    /**
     * 严格表
     */
    public int solution3(int n,int s,int e,int k){
        int[][] record = new int[n+1][k+1];
        for (int i = 0; i < k+1; i++) {
            record[0][i] = 0;
        }
        for (int i = 0; i < n+1; i++) {
            if (i==e){
                record[i][0] = 1;
            }else {
                record[i][0] = 0;
            }
        }
        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (j<n){
                    int a = record[j-1][i-1];
                    int b = record[j+1][i-1];
                    record[j][i] = a+b;
                }else {
                    record[j][i] = record[j-1][i-1];
                }
            }
        }
        return record[s][k];
    }
}
