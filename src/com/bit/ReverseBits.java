package com.bit;

/**
 * @ClassName ReverseBits
 * @Author Jacky
 * @Description
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }
}
