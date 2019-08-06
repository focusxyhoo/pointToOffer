package questions;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-22
 * time        : 11:29
 * description :
 */
public class T58_LeftRotateString {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(leftRotateString(s, 2));
        System.out.println(leftRotateString2(s, 2));
    }

    // java 中的 substring 方法很简单就能实现该函数
    // 但是会利用额外的空间
    public static String leftRotateString(String s, int n) {
        String s1 = s.substring(n);
        String s2 = s.substring(0, n);
        return s1 + s2;
    }

    // 利用上一题的 reverse 函数，翻转三次即可得到结果。
    public static String leftRotateString2(String s, int n) {

        // 对于字符串的处理，一定要要考虑特殊情况
        if (null == s || s.length() == 0) return null;

        char[] temp = s.toCharArray();
        T58_ReverseWordsInSentence.reverse(temp, 0, n - 1);
        T58_ReverseWordsInSentence.reverse(temp, n, temp.length - 1);
        T58_ReverseWordsInSentence.reverse(temp, 0, temp.length - 1);
        return new String(temp);
    }
}
