package questions;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-22
 * time        : 11:16
 * description :
 */
public class T58_ReverseWordsInSentence {
    public static void main(String[] args) {
        String sentence = "I am a student.";
        System.out.println(reverseSentence(sentence));

    }

    public static String reverseSentence(String sentence) {
        char[] temp = sentence.toCharArray();
        int len = sentence.length();
        reverse(temp, 0, len - 1);
        System.out.println(temp);

        int prev = 0;
        for (int i = 0; i < len; i++)
            if (temp[i] == ' ') {
                reverse(temp, prev, i - 1);
                prev = i + 1;
            }
        return new String(temp);
    }

    public static void reverse(char[] s, int l, int h) {
        if (null == s || s.length == 0 || l < 0 || l >= h || h > s.length - 1) return;

        while (l < h) {
            char temp = s[h];
            s[h] = s[l];
            s[l] = temp;
            l++;
            h--;
        }
    }
}
