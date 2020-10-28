//You are given a series of video clips from a sporting event that lasted T seco
//nds. These video clips can be overlapping with each other and have varied length
//s. 
//
// Each video clip clips[i] is an interval: it starts at time clips[i][0] and en
//ds at time clips[i][1]. We can cut these clips into segments freely: for example
//, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7]. 
//
// Return the minimum number of clips needed so that we can cut the clips into s
//egments that cover the entire sporting event ([0, T]). If the task is impossible
//, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
//Output: 3
//Explanation: 
//We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
//Then, we can reconstruct the sporting event as follows:
//We cut [1,9] into segments [1,2] + [2,8] + [8,9].
//Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0,
// 10].
// 
//
// Example 2: 
//
// 
//Input: clips = [[0,1],[1,2]], T = 5
//Output: -1
//Explanation: 
//We can't cover [0,5] with only [0,1] and [1,2].
// 
//
// Example 3: 
//
// 
//Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2
//,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
//Output: 3
//Explanation: 
//We can take clips [0,4], [4,7], and [6,9].
// 
//
// Example 4: 
//
// 
//Input: clips = [[0,4],[2,8]], T = 5
//Output: 2
//Explanation: 
//Notice you can have extra video after the event ends.
// 
//
// 
// Constraints: 
//
// 
// 1 <= clips.length <= 100 
// 0 <= clips[i][0] <= clips[i][1] <= 100 
// 0 <= T <= 100 
// 
// Related Topics 动态规划 
// 👍 202 👎 0


package com.mervyn.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    //1024
    public static void main(String[] args) {
        Solution solution = new VideoStitching().new Solution();
        solution.videoStitching(new int[][]{{0,5},{6,8}}, 7);
    }

    /**
     * 我是笨蛋
     * dp[i]：对[0,i)的时间需要的最少碎片数。
     * dp[0]:[0,0)无意义，设为0
     *
     * 对每个碎片如果：clips[a][0] <= i <= clips[a][1]
     * 有可以取或不取
     * dp[i] = min(dp[i], dp[clips[a][0]]+1)
    */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T+1];
            Arrays.fill(dp, Integer.MAX_VALUE-1);
            dp[0] = 0;
            for (int i = 1; i <= T; ++i) {
                for (int[] clip : clips) {
                    if (clip[1] >= i && clip[0] <= i) {
                        dp[i] = Math.min(dp[i], dp[clip[0]]+1);
                    }
                }
            }
            return dp[T] == Integer.MAX_VALUE-1?-1:dp[T];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}