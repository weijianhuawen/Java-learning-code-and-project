import java.util.HashMap;

public class Main {

}

class KnapsackProblem {
    /**
     *
     * @param N 物品数
     * @param C 背包容量
     * @param v 每件的体积
     * @param w 每件物品的价值
     * @return 最大价值
     */
    public int zoKnapsack(int N, int C, int[] v, int[] w) {
        //0-1背包朴素
        int[][] dp = new int[N][C+1];
        //初始化
        for (int j = 0; j <= C; j++) {
            dp[0][j] = j >= v[0] ? w[0] : 0;
        }

        //处理剩余元素
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                //不选
                int x = dp[i-1][j];
                //选
                int y = j >= v[i] ? dp[i-1][j-v[i]] + w[i] : 0;
                //取两者中的最大值
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[N-1][C];
    }

    public int zoKnapsackPlus(int N, int C, int[] v, int[] w) {
        //0-1背包滚动数组优化
        int[][] dp = new int[2][C+1];
        //初始化
        for (int j = 0; j <= C; j++) {
            dp[0][j] = j >= v[0] ? w[0] : 0;
        }

        //处理剩余元素
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                //不选
                int x = dp[(i-1) & 1][j];
                //选
                int y = j >= v[i] ? dp[(i-1) & 1][j-v[i]] + w[i] : 0;
                //取两者中的最大值
                dp[i&1][j] = Math.max(x, y);
            }
        }
        return dp[(N-1) & 1][C];
    }
    public int zoKnapsackOnePlus(int N, int C, int[] v, int[] w) {
        HashMap
        //0-1背包滚动数组优化
        int[] dp = new int[C+1];
        //初始化
        for (int j = 0; j <= C; j++) {
            dp[j] = j >= v[0] ? w[0] : 0;
        }

        //处理剩余元素
        for (int i = 1; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
                //不选
                int x = dp[j];
                //选
                int y = dp[j-v[i]] + w[i];
                //取两者中的最大值
                dp[j] = Math.max(x, y);
            }
        }
        return dp[C];
    }
}
