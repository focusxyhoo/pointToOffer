package questions;

// 动态规划和贪婪算法
// DP的三个特点：
// 1 求一个问题的最优解
// 2 整体问题的最优解依赖于各个子问题的最优解
// 3 将大问题分解成若干小问题，这些小问题之间还有相互重叠的更小子问题
// 解法：基本都是从f(0)、f(1)等基础条件往上推出f(n)，用数组存储中间数据
public class P14_CuttingRope {
    public static int maxCuttingRope(int len) {
        if (len < 2) return 0;
        if (len == 2) return 1;
        if (len == 3) return 2;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        int temp;
        for (int i = 4; i <= len; i++) {
            for (int j = 1; j <= i / 2; j++) {
                temp = dp[j] * dp[i - j];
                if (max < temp)
                    max = temp;
            }
            dp[i] = max;
        }
        return dp[len];
    }

    // 贪婪算法
    public static int maxCuttingRope2(int len) {
        if (len < 2) return 0;
        if (len == 2) return 1;
        if (len == 3) return 2;
        // 尽可能多地去剪长度为3的绳子段
        int timesOf3 = len / 3;
        if (len - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (len - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));

    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println(maxCuttingRope(i));
            System.out.println(maxCuttingRope2(i));
        }

    }
}
