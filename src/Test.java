import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(0.1 * 3 == 0.3);
        byte a = 1;
        byte b = 2;
        // 错误，因为byte做运算会升级到int类型，无法赋值给b
//        b = a + b;
        // 而
        b += a;
        System.out.println();
        // lambda表达式
        List<String> names = Arrays.asList("hello", "world", "welcome");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        Collections.sort(names, (String c, String d) -> d.compareTo(c));



    }
}

// 函数式接口
@FunctionalInterface
interface Coverter<F, T> {
    T convert(F from);
}
