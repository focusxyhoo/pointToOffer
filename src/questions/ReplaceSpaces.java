package questions;

public class ReplaceSpaces {
    public static String replaceSpace(String str) {
        return str.replace(" ", "%20");
    }

    public static String replaceSpaces1(String str) {
        char[] s = str.toCharArray();
        int len = str.length();
        int lenNew = len;
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                lenNew += 2;
            }
        }

        char[] result = new char[lenNew];
        for (int indexOld = len - 1, indexNew = lenNew - 1; indexOld >=0 && indexNew != indexOld; indexNew--, indexOld--) {
            if (s[indexOld] == ' ') {
                result[indexNew--] = '0';
                result[indexNew--] = '2';
                result[indexNew] = '%';
            } else {
                result[indexNew] = s[indexOld];
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = " We are happy ";
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpaces1(s));
    }
}
