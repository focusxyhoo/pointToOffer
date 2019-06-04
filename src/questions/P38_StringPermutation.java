package questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 字符串的排列问题
 * <p>
 * 可以理解为：将字符串分为两个部分，分别是第一个字符以及剩下的字符
 * 在第一个字符确定后，接下来就是求剩下的字符的排列
 * 这就很容易用递归的思路来解决问题
 * <p>
 * 下标为 index 的字符将会依次与 [index, length) 位置上的字符进行交换
 * 注意，仅当不相同时才交换
 * 且直到最后一个字符才打印输出
 * <p>
 * 举例：aba
 * 0（下标）与0为止下的字符交换，得 aba => 1与1交换，得 aba => 2与2交换，得aba，打印；
 *                                  => 1与2交换，得 aab => 2与2交换，得aab，打印；
 * 0与1交换，得baa => 1与1交换，得 baa => 2与2交换，得baa，打印；
 *                => 1与2相同，不交换；
 * 0与2相同，不交换。
 *
 * @author focusxyhoo
 * @date 2019-05-27 20:23
 */
public class P38_StringPermutation {
    public static void main(String[] args) {
        String str = "aba";
        System.out.println("输入的字符串为：" + str);
        System.out.println("该字符串的所有可能排列为：");
        permutation(str);
    }

    public static void permutation(String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        char[] chars = string.toCharArray();
        permutationCore(chars, 0);
    }

    private static void permutationCore(char[] chars, int index) {
        if (index == chars.length) {
            System.out.println(chars);
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            // 通过将每一个元素添加到 Set 集合来判断该元素是否是重复的
            if (set.add(chars[i])) {
                swap(chars, index, i);
                permutationCore(chars, index + 1);
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
