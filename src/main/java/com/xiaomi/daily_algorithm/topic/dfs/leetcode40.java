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
        return res;

    }

    public static void dfs(int[] candidates, List<Integer> ans, List<List<Integer>> res, int step, boolean[] b, int target) {
        if (target < 0) {
            return ;
        }
        if (target == 0) {
            for (int v : ans) {
                System.out.print(v + " ");
            }
            System.out.println();
            res.add(new ArrayList<>(ans));
            return ;
        }
        for (int i = step; i < candidates.length; i ++ ) {

                ans.add(candidates[i]);
                dfs(candidates, ans, res, i + 1, b, target - candidates[i]);
                ans.remove(ans.size() - 1);
                while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                    i ++;
                }

        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
