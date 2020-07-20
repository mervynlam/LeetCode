package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 *
 * i - K <= r <= i + K, j - K <= c <= j + K 
 * (r, c) 在矩阵内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-block-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int matSize = (int) Math.sqrt(inputArr.length-1);
            int[][] mat = new int[matSize][matSize];
            int index = 0;
            for (int i = 0; i < matSize; ++i) {
                for (int j = 0; j < matSize; ++j) {
                    mat[i][j] = Integer.valueOf(inputArr[index++]);
                }
            }
            int k = Integer.valueOf(inputArr[inputArr.length-1]);
            int[][] ret = matrixBlockSum(mat, k);
            if (ret == null) {
                System.out.println("null");
                return;
            }
            if (ret.length == 0) {
                System.out.println("[]");
                return;
            }

            StringBuilder sb = new StringBuilder("[");
            for (int[] item : ret) {
                sb.append(Arrays.toString(item));
                sb.append(",");
            }

            sb.setCharAt(sb.length() - 1, ']');
            System.out.println(sb.toString());
        }
    }

    /**
     * 求矩阵和：[0,0] - [i,j]的和
     * ans[i][j] = sum[i+K][j+K] - sum[i-K-1][j+K] - sum[i+K][j-K-1] + sum[i-K-1][j-K-1]
     */
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int len1 = mat.length;
        int len2 = mat[0].length;
        int[][] sum = new int[len1+1][len2+1];
        int[][] answer = new int[len1][len2];

        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + mat[i][j];
            }
        }

        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                int x1 = Math.max(0, i-K);
                int x2 = Math.min(len1, i+K+1);
                int y1 = Math.max(0, j-K);
                int y2 = Math.min(len2, j+K+1);
                answer[i][j] = sum[x2][y2]-sum[x1][y2]-sum[x2][y1]+sum[x1][y1];
            }
        }
        return answer;
    }
}