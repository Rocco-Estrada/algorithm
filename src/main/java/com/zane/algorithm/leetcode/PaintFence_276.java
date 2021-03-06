package com.zane.algorithm.leetcode;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same
 * color.
 * <p>
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note: n and k are non-negative integers.
 * Author: luojinping
 * Date: 16/3/27
 * Time: 17:29
 */
public class PaintFence_276 {
    public class Solution {
        public int numWays(int n, int k) {
            // 当n=0时返回0
            int dp[] = {0, k, k * k, 0};
            if (n <= 2) {
                return dp[n];
            }
            for (int i = 2; i < n; i++) {
                // 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
                dp[3] = (k - 1) * (dp[1] + dp[2]);
                dp[1] = dp[2];
                dp[2] = dp[3];
            }
            return dp[3];
        }
    }
}
