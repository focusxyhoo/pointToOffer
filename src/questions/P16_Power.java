package questions;

public class P16_Power {
    static boolean isInvalidInput = false;
    public static double power(double base, int exponent) {
        double result = 0.0;
        if (equal(base, 0.0) && exponent < 0 ) {
            isInvalidInput = true;
            return 0.0;
        }
        if (exponent < 0) {
            return 1 / powerWithPositiveExponent(base, -1 * exponent);
        } else {
            return powerWithPositiveExponent(base, exponent);
        }
    }

    private static boolean equal(double x, double y) {
        return -0.00001 < x-y && y - x < 0.00001;
    }

    private static double powerWithPositiveExponent(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        // 通过位运算判断是否exponent是否是偶数
        if ((exponent & 1) == 0) {
            double result = powerWithPositiveExponent(base, exponent >> 1);
            return result * result;
        } else {
            double result = powerWithPositiveExponent(base, exponent >> 1);
            return result * result * base;
        }
    }

    public static void main(String[] args) {
        System.out.println("12^(2)=" + power(12, 2) + "是否报错：" + isInvalidInput);
        System.out.println("0^(-4)=" + power(0, -4) + "是否报错：" + isInvalidInput);
        // 问题：当isInvalidInput被修改为true后，后续的操作如何改回来
        System.out.println("3^(-1)=" + power(3, -1) + "是否报错：" + isInvalidInput);
    }
}
