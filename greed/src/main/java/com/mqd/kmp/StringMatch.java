package com.mqd.kmp;

/**
 * kmp字符转匹配
 */
public class StringMatch {

    public static void main(String[] args) {
        String str1 = "abadababdababasfas";
        String str2 = "ababa";
        int i = stringKmpMatch(str1, str2);
        System.out.println(i);

    }


    /**
     * 通过kmp算法来匹配str2在str1中第一次出现的位置
     * @param str1  str1
     * @param str2  str2
     * @return  返回第一次出现的下标
     */
    public static int stringKmpMatch(String str1, String str2){
        if (str1.length() < 1 || str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] next = getNextArr(chars2);
        int i1 = 0;
        int i2 = 0;
        while (i1<chars1.length && i2<chars2.length){
            if (chars1[i1] == chars2[i2]){
                i1++;
                i2++;
            } else if (next[i2] == -1){
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length() ? i1-i2 : -1;
    }
    /**
     * 构建String2的next数组
     * @return  返回构建好的数组
     */
    public static int[] getNextArr(char[] arr){
        if (arr.length == 1){
            return new int[]{-1};
        }
        int[] res = new int[arr.length];
        res[0] = -1;
        res[1] = 0;
        int i = 2;  // 前进的游标
        int mp = 0; //比对的游标
        while (i<arr.length){
            //先检查i-1位置的是否跟mp位置的元素相等，如果相等，则当前i元素的值直接等于mp+1
            if (arr[mp] == arr[i-1]){
                res[i++] = ++mp;
            }else if (mp > 0){  //当mp大于0的时候往前跳
                mp = res[mp];
            }else {
                res[i++] = 0;
            }
        }
        return res;
    }
}
