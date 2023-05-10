package com.xiaomi.daily_algorithm.topic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
    static List<Integer> ans = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] b = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, ans, res, 0, b, target);
        System.out.println(res.size());
        for (List<Integer> r : res) {
            System.out.println(r);
        }
        return res;

    }

    public static void dfs(int[] candidates, List<Integer> ans, List<List<Integer>> res, int step, boolean[] b, int target) {
        if (target < 0) {
            return ;
        }
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return ;
        }
        for (int i = step; i < candidates.length; i ++ ) {
            if (!b[i]) {
                if (i > step && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                ans.add(candidates[i]);
                b[i] = true;
                dfs(candidates, ans, res, step + 1, b, target - candidates[i]);
                ans.remove(ans.size() - 1);
                b[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
