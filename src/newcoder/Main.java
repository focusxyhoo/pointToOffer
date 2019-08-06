package newcoder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-03
 * time        : 15:19
 * description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[] temp = new int[q];
        for (int i = 0; i < q; i++) {
            temp[i] = scanner.nextInt();
        }
        for (int i = 0; i < temp.length; i++) {
            getPercent(scores, temp[i] - 1);
        }

    }

    public static void getPercent(int[] scores, int index) {
        if (index < 0 || index >= scores.length) return;
        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] <= scores[index]) count++;
        }
//        double result = new BigDecimal((double) ((count - 1) * 100) / scores.length).setScale(6, RoundingMode.HALF_DOWN).doubleValue();
        DecimalFormat decimalFormat = new DecimalFormat("0.000000");
        String result = decimalFormat.format((double) ((count - 1) * 100) / scores.length);
        System.out.println(result);
    }
}
