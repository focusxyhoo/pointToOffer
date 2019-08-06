package newcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 23:01
 * description :
 * 运行时间：1018ms
 * 占用内存：151900k
 */
public class Problem10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] interst = new int[n];
        int[] awake = new int[n];
        for (int i = 0; i < n; i++) {
            interst[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            awake[i] = scanner.nextInt();
        }

        int baseScore = 0;
        for (int i = 0; i < n; i++) {
            if (awake[i] == 1) baseScore += interst[i];
        }
        int maxUp = 0;
        for (int i = 0; i < n; i++) {
            if (awake[i] == 0) {
                int temp = getUpScore(interst, awake, i, k);
                maxUp = temp > maxUp ? temp : maxUp;
                if (i > n - k + 1) break; // 扫描到距结尾不足 k 距离范围内的第一个睡着状态即可，后面的肯定不如这个的提升值大
            }
        }
//        System.out.println(maxUp);
        System.out.println(baseScore + maxUp);
    }

    private static int getUpScore(int[] a, int[] b, int i, int k) {
        int upScore = 0;
//        System.out.println("调用前：" + upScore);
        for (int j = i; j < a.length && j < i + k; j++) {
//            System.out.println(j);
            if (b[j] == 0) upScore += a[j];
        }
//        System.out.println("调用后：" + upScore);
        return upScore;
    }
}
