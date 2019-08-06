package newcoder;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-29
 * time        : 17:19
 * description : https://www.nowcoder.com/practice/9173e83d1774462f81255a26feafd7c6?tpId=98&tqId=32830&tPage=1&rp=1&ru=%2Fta%2F2019test&qru=%2Fta%2F2019test%2Fquestion-ranking
 */
public class Problem7 {

    static class Time implements Comparable<Time> {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this. minute = minute;
            adjust();
        }

        public Time add(int minute) {
            return new Time(this.hour, this.minute + minute);
        }

        private void adjust() {
            if (minute >= 60) {
                hour += minute / 60;
                minute %= 60;
            }
        }

        @Override
        public int compareTo(Time o) {
            if (this.hour < o.hour) return -1;
            else if (this.hour > o.hour) return 1;
            else {
                if (this.minute < o.minute) return -1;
                else if (minute > o.minute) return 1;
                else return 0;
            }
        }

        @Override
        public String toString() {
            return hour + " : " + minute;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            int m = scanner.nextInt();
            list.add(new Time(h, m));
        }
        int time = scanner.nextInt();
        int classHour = scanner.nextInt();
        int classMinute = scanner.nextInt();
        Time classTime = new Time(classHour, classMinute);

        Collections.sort(list); // 排序
        for (int i = n - 1; i >= 0; i--) {
            Time curr = list.get(i);
            Time temp = curr.add(time);
            if (temp.compareTo(classTime) <= 0) {
                System.out.println(curr.hour + " " + curr.minute);
                break;
            }
        }
    }
}
