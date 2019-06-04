package questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串的组合问题
 *
 * @author focusxyhoo
 * @date 2019-05-27 21:19
 */
public class P38_StringCombination {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("输入的字符串为：" + str);
        System.out.println("该字符串的所有可能组合为（位运算）：");
        for (String item : combine(str.toCharArray())) {
            System.out.println(item);
        }
        System.out.println("该字符串的所有可能组合为（递归思想）：");
        combination(str);
    }

    /**
     * 递归思想
     * @param string
     */
    public static void combination(String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        combinationCore(chars, new StringBuilder(), 0);
    }

    private static void combinationCore(char[] chars, StringBuilder stringBuilder, int index) {
        if (index == chars.length) {
            if (stringBuilder.length() > 0) {
                System.out.println(stringBuilder.toString());
            }
        } else if (index + 1 == chars.length || chars[index] != chars[index + 1]) {
            combinationCore(chars, stringBuilder.append(chars[index]), index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            combinationCore(chars, stringBuilder, index + 1);
        } else {
            // 先计算出重复次数
            int dumplicationStart = index;
            while (index != chars.length && chars[dumplicationStart] == chars[index]) {
                stringBuilder.append(chars[index]);
                index++;
            }
            int newStart = index;
            while (index >= dumplicationStart) {
                combinationCore(chars, stringBuilder, newStart);
                if (index != dumplicationStart) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                index--;
            }
        }
    }

    /**
     * 利用位运算来返回字符数组 chars 的 全组合。
     * 参考链接：http://www.holen.cc/2015/09/08/字符串排列组合——Java实现/
     *
     * @param chars
     * @return
     */
    public static List<String> combine(char[] chars) {
        List<String> list = new LinkedList<>();
        // 根据 chars 的长度 length 可以确定有 2^length-1 种组合情况。
        // 注意用位运算 1<<length 来表示表达式 2^length-1 的使用
        // i 的位上是1，表示选择该位上的字符
        for (int i = 0; i < (1 << chars.length); i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                // 利用j的取值来判断被选择的字符
                if ((i & (1 << j)) != 0) {
                    result.append(chars[j]);
                }
            }
            // 过滤掉 result 为空的情况
            if (result.length() != 0) {
                list.add(result.toString());
            }
        }
        return list;
    }
}
