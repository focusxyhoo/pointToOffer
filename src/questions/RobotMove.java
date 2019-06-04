package questions;

// 同样为回溯法，解决机器人在方格上的移动问题
// 通常物体或者人在二维方格运动这类问题都可以通过回溯法解决
public class RobotMove {

    //
    public static int movingCount(int k, int rows, int cols) {
        // 极端情况
        if (rows < 1 || cols < 1 || k < 0)
            return 0;
        // 设置与输入二维数组大小一样的标志位，判断是否已visited
        boolean[][] flags = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                flags[i][j] = false;
        return movingCountCore(k, rows, cols, 0, 0, flags);
    }

    //
    private static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[][] flags) {
        int count = 0;
        if (isLegal(k, rows, cols, row, col, flags)) {
            flags[row][col] = true;
            count = 1 + movingCountCore(k, rows, cols, row + 1, col, flags) +
                    movingCountCore(k, rows, cols, row - 1, col, flags) +
                    movingCountCore(k, rows, cols, row, col + 1, flags) +
                    movingCountCore(k, rows, cols, row - 1, col, flags);
        }
        return count;
    }

    // 判断当前方格是否是合法的
    private static boolean isLegal(int k, int rows, int cols, int row, int col, boolean[][] flags) {
        return row >= 0 && col >= 0 && row < rows && col < cols && !flags[row][col] &&
                getDigitSum(row) + getDigitSum(col) <= k;
    }

    // 求一个整数的各位之和
    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2, 5, 5));
        System.out.println(movingCount(5, 5, 5));
    }
}
