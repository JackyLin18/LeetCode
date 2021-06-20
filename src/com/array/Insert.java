package com.array;

/**
 * @ClassName Insert
 * @Author Jacky
 * @Description
 **/
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int i;
        for (i = 0; i < length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                break;
            }
        }
        if (i != 0) {
            i--;
        }
        return null;
    }
}
