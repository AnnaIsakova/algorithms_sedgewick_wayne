package fundamentals;


import java.util.ArrayList;

//What is the largest value of N for which this program takes less 1 hour to compute the
//        value of F(N)? Develop a better implementation of F(N) that saves computed values in
//        an array.
public class Fibonacci1_1_19 {
    public static long F(int N)
    {
        ArrayList<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        if (N == 0) return 0;
        if (N == 1) return 1;
        for (int i = 2; i <= N; i++) {
            list.add(list.get(i-2) + list.get(i-1));
        }
        return list.get(N);
    }
    public static void main(String[] args)
    {
        for (int N = 0; N < 100; N++)
            System.out.println(N + " " + F(N));
    }
}
