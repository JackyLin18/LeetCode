package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SubsetsWithDup
 * @Author Jacky
 * @Description
 **/
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        int pre = nums[0];
        List<Integer> temp = new ArrayList<>();
        temp.add(pre);
        result.add(temp);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                result.add(new ArrayList<>(pre));
            }
            for (int j = i; j < nums.length; j++) {

            }
            pre = nums[i];
        }
        return result;
    }


}
