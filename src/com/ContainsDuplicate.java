package com;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * @ClassName ContainsDuplicate
 * @Author Jacky
 * @Description
 **/
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate o = new ContainsDuplicate();
        int[] nums = {1,2,3,4};
        System.out.println(o.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
