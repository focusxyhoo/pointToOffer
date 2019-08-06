package newcoder;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 15:41
 * description : https://www.nowcoder.com/practice/bac5a2372e204b2ab04cc437db76dc4f?tpId=98&tqId=32828&tPage=1&rp=1&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long count = 0;
        for (int y = k + 1; y <= n; y++) {
            int res = n / y * (y - k);
            if (n % y >= k) {
                if (k != 0) res += n % y - k + 1;
                else res += n % y;
            }
            count += res;
        }
        System.out.println(count);

    }
}
