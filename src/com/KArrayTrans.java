package com;

/**
 * @ClassName KArrayTrans
 * @Author Jacky
 * @Description
 **/
public class KArrayTrans {
    public static void main(String[] args) {
//        int[] A = {0, 0, 0, 1, 0, 1, 1, 0};
//        int K = 3;
//        int[] A = {1, 1, 0};
//        int K = 3;
        int[] A = {1, 1, 0, 1};
        int K = 2;
        System.out.println(new KArrayTrans().minKBitFlips(A, K));
    }

    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        int size = A.length;
        int tranFlag;
        for (tranFlag = 0; tranFlag + K <= size; ) {
            if (A[tranFlag] == 1) {
                tranFlag++;
                continue;
            }
            for (int i = 0; i < K; i++) {
                A[tranFlag + i] = trans(A[tranFlag + i]);
            }
            count++;
            tranFlag++;
        }
        if (tranFlag >= size) {
            return count;
        }
        for (int i = tranFlag; i < size; i++) {
            if (A[i] == 0) {
                return -1;
            }
        }
        return count;
    }

    public int trans(int i) {
        if (i == 1) {
            return 0;
        } else {
            return 1;
        }
    }
}
