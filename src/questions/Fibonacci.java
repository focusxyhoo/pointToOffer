package questions;

public class Fibonacci {
    // 斐波那契数列：写法都很简单，第三种方法不实用，这里没写
    // 更多的是要注意follow up， 比如跳台阶、方块重叠等变种问题
    // 迭代法
    public static int fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //
    public static int fibonacci1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int result = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++)
            System.out.println(i + ": " + fibonacci(i));

        for (int i = 0; i < n; i++)
            System.out.println(i + ": " + fibonacci1(i));
    }
}
