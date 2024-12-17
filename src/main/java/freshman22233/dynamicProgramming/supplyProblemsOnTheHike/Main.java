package freshman22233.dynamicProgramming.supplyProblemsOnTheHike;

/**
 * 问题描述
 * 小R正在计划一次从地点A到地点B的徒步旅行，
 * 总路程需要 N 天。
 * 为了在旅途中保持充足的能量，
 * 小R每天必须消耗1份食物。
 * 幸运的是，小R在路途中每天都会经过一个补给站，
 * 可以先购买完食物后再消耗今天的1份食物。
 * 然而，每个补给站的食物每份的价格可能不同，
 * 并且小R在购买完食物后最多只能同时携带 K 份食物。
 * 现在，小R希望在保证每天食物消耗的前提下，
 * 以最小的花费完成这次徒步旅行。你能帮助小R计算出最低的花费是多少吗？
 * **输入 **
 * n 总路程需要的天数
 * k 小R最多能同时携带食物的份数
 * data[i] 第i天补给站每份食物的价格
 * **输出 **
 * 返回完成这次徒步旅行的最小花费
 * **约束条件 **
 * 1 < n,k < 1000
 * 1 < data[i] < 10000
 * 测试样例
 * 样例1：
 * 输入：n = 5 ,k = 2 ,data = [1, 2, 3, 3, 2]
 * 输出：9
 * 样例2：
 * 输入：n = 6 ,k = 3 ,data = [4, 1, 5, 2, 1, 3]
 * 输出：9
 * 样例3：
 * 输入：n = 4 ,k = 1 ,data = [3, 2, 4, 1]
 * 输出：10
 */

public class Main {
    public static int solution(int n, int k, int[] data) {
        /**
         * Denote
         * DP: cost
         * i: day i
         * j: the unit leaf at the end of day i
         * y: buy y unit
         * m: the unit number at the start of day i
         */
        //1.Initiation
        int INF = Integer.MAX_VALUE / 2;
        int[][] DP = new int[n + 1][k+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                DP[i][j] = INF;
            }
        }
        DP[0][0] = 0;

        //2.compute DP
        //i: day i
        for (int i = 1; i <= n; i++) {
            //j: the unit leaf at the end of day i
            for (int j = 0; j <= k; j++) {
                // constrain: capacity
                if (j + 1 > k) {
                    continue;
                }
                //m: the unit number at the start of day i
                for (int m = 0; m <= k; m++) {
                    /**
                     * y: buy y unit - we can derive y = j-m+1
                     *  end(j) - start(m)= consume(-1) + buy(y)
                     */

                    int y = j - m + 1;
                    if (y < 0) {
                        continue;
                    }
                    if (DP[i - 1][m] == INF) {
                        continue;
                    }
                    int costToday = y * data[i - 1];

                    int newcost = DP[i - 1][m] + costToday;

                    if (newcost < DP[i][j]) {
                        DP[i][j] = newcost;
                    }

                }
            }
        }

        /**
         * find the optimal cost
         */
        int ans = INF;
        for (int j = 0; j <= k; j++) {
            if(DP[n][j] < ans){
                ans = DP[n][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(solution(5, 2, new int[]{1, 2, 3, 3, 2}) == 9); // Expected 9
        System.out.println(solution(6, 3, new int[]{4, 1, 5, 2, 1, 3}) == 9); // Expected 9
        System.out.println(solution(4, 1, new int[]{3, 2, 4, 1}) == 10); // Expected 10
    }
}


