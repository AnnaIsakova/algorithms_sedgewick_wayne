package fundamentals;


import java.util.Arrays;

//Write a static method histogram() that takes an array a[] of int values and
//        an integer M as arguments and returns an array of length M whose ith entry is the number
//        of times the integer i appeared in the argument array. If the values in a[] are all
//        between 0 and M–1, the sum of the values in the returned array should be equal to
//        a.length.
public class Histogram1_1_15 {
    public static void main(String[] args) {
        int[] a = {3, 5, 5, 2};
        System.out.println(Arrays.toString(histogram(a, 6)));
    }

    public static int[] histogram(int[] a, int M){
        int[] array = new int[M];
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i){
                    times++;
                }
            }
            array[i] = times;
            times = 0;
        }
        return array;
    }
}
