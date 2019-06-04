package questions;

// 位运算
public class P15_NumberOf1InBinary {
    public static int numberOfOne(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag <<= 1;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(11));
        System.out.println(numberOfOne(111));
        System.out.println(numberOfOne(11111));
    }
}
