package questions;

public class StringPathInMatrix {
    // 回溯法
    public static boolean hasPath(char[][] chars, String s) {
        int rows = chars.length;
        int cols = chars[0].length;
        if (chars == null || rows < 1 || cols < 1 || s == null || s.length() < 1)
            return false;
        int len = s.length();
        // 设置并初始化标志位为false
        boolean[][] flags = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                flags[row][col] = false;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(chars, row, col, flags, s, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] chars, int rowIndex, int colIndex, boolean[][] flags, String s, int sIndex) {
        // 结束条件
        if (sIndex >= s.length()) {
            return true;
        }
        if (rowIndex < 0 || rowIndex >= chars.length || colIndex < 0 || colIndex >= chars[0].length) {
            return false;
        }
        // 递归
        // 如果当前位置未被访问，且匹配字符串，则标记为已访问，再分上下左右四个方向求解
        if (!flags[rowIndex][colIndex] && chars[rowIndex][colIndex] == s.charAt(sIndex)) {
            flags[rowIndex][colIndex] = true;
            boolean result = hasPathCore(chars, rowIndex + 1, colIndex, flags, s, sIndex + 1) ||
                    hasPathCore(chars, rowIndex - 1, colIndex, flags, s, sIndex + 1) ||
                    hasPathCore(chars, rowIndex, colIndex + 1, flags, s, sIndex + 1) ||
                    hasPathCore(chars, rowIndex, colIndex - 1, flags, s, sIndex + 1);
            if (result)
                return true;
            else {
                flags[rowIndex][colIndex] = false;
                return false;
            }
        } else
            return false;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'}};
        System.out.println(hasPath(chars, "abfgkji"));
        System.out.println(hasPath(chars, "abcdefg"));
    }
}
