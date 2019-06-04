package questions;

public class FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrix(int[][] mat, int n) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }
        int rowNum = mat.length - 1;
        int colNum = mat[0].length - 1;
        int rowCur= 0;
        int colCur = colNum;
//        while (true) {
//            if (rowCur > rowNum || colCur < 0)
//                return false;
//            if (mat[rowCur][colCur] == n) {
//                return true;
//            } else if (mat[rowCur][colCur] < n) {
//                rowCur++;
//            } else if (mat[rowCur][colCur] > n) {
//                colCur--;
//            }
//        }

        while (rowCur <= rowNum && colCur >= 0) {
            if (mat[rowCur][colCur] == n) {
                return true;
            } else if (mat[rowCur][colCur] < n) {
                rowCur++;
            } else if (mat[rowCur][colCur] > n) {
                colCur--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 8, 9},
                       {2, 4, 9, 12},
                       {4, 7, 10, 13}};
        System.out.println(findInPartiallySortedMatrix(mat, 10));
        System.out.println(findInPartiallySortedMatrix(mat, 100));
    }
}
