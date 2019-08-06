package questions;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-22
 * time        : 10:12
 * description :
 */
public class T57_ContinuousSequenceWithSum {
    public static void main(String[] args) {
        findContinuousSequence(4);

    }

    public static void findContinuousSequence(int sum) {

        if (sum < 3) return;

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curr = small + big;

        while (small < middle) {
            if (curr == sum) printContinuousSequence(small, big);

            // 注意这里的逻辑顺序，并不是 if else else。
            // 当相等时，打印输出，然后 big 继续增大，
            // 当 curr 大于时，进入循环，删去最小的值，
            while (curr > sum && small < middle) {
                curr -= small;
                small++;

                if (curr == sum) printContinuousSequence(small, big);
            }

            big++;
            curr += big;
        }

        System.out.println(sum);
    }

    public static void printContinuousSequence(int a, int b) {
        for (int i = a; i < b; i++) {
            System.out.print(i + " + ");
        }
        System.out.print(b + " = ");
    }
}
