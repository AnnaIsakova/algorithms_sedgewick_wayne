package fundamentals;


//Write a BinarySearch client that takes an int value T as
//        command-line argument and runs T trials of the following experiment for N = 10^3, 10^4,
//        10^5, and 10^6: generate two arrays of N randomly generated positive six-digit int values,
//        and find the number of values that appear in both arrays. Print a table giving the average
//        value of this quantity over the T trials for each value of N.

import java.util.Scanner;

public class RandomMatches1_1_39 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of trials: ");
        int T = scanner.nextInt();
        int[] repeats = new int[4]; //all repeats for each N in all runs
        double[] result; //average repeats for each N
        for (int i = 0; i < T; i++) {
            calcRepeats(repeats);
        }
        result = getResults(repeats, T);
        printTable(result);
    }

    public static void printTable(double[] results){
        System.out.println("  N   |" + "  Repeats");
        int exp = 3;
        for (int i = 0; i < results.length; i++) {
            System.out.println("10^" + exp + "  |  " + results[i]);
            exp++;
        }
    }

    public static double[] getResults(int[] repeats, int T){
        double[] results = new double[repeats.length];
        for (int i = 0; i < repeats.length; i++) {
            results[i] = (double)repeats[i]/T;
        }
        return results;
    }

    public static void calcRepeats(int[] repeats){
        int exp = 3;
        for (int j = 0; j < repeats.length; j++) {
            repeats[j] += getRepeat((int) Math.pow(10, exp));
            exp++;
        }
    }

    public static int getRepeat(int N){
        int repeat = 0;
        int[] firstArr = generateArray(N);
        int[] secondArr = generateArray(N);
        for (int j = 0; j < firstArr.length; j++) {
            int result = rank(firstArr[j], secondArr);
            if (result > -1){
                repeat++;
            }
        }
        return repeat;
    }

    public static int[] generateArray(int N){
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = 100000 + (int)(Math.random() * ((999999 - 100000) + 1));
        }
        return arr;
    }

    public static int rank(int key, int[] a)
    { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


}
