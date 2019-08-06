package newcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 11:48
 * description : https://www.nowcoder.com/practice/46e837a4ea9144f5ad2021658cb54c4d?tpId=98&tqId=32824&tPage=1&rp=1&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] cap = new int[n + m];
        int[] friend = new int[n];
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            cap[i] = key;
            if (map.containsKey(key) && map.get(key) >= value) continue;
            map.put(key, value);
        }

        for (int i = 0; i < m; i++) {
            int temp = scanner.nextInt();
            cap[n + i] = temp;
            friend[i] = temp;
            if (!map.containsKey(temp)) map.put(temp, 0);
        }

        Arrays.sort(cap);
        int max = 0;
        for (int i = 0; i < n + m; i++) {
            max = Math.max(max, map.get(cap[i]));
            map.put(cap[i], max);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(friend[i]));
        }
    }

}
