package fundamentals;


//Remove duplicates. Modify the test client in BinarySearch to remove any duplicate
//        keys in the whitelist after the sort.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch1_1_28 {
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
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);

        int temp = whitelist[whitelist.length - 1];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < whitelist.length; i++) {
            if (temp == whitelist[i] && whitelist.length > 1) continue;
            temp = whitelist[i];
            list.add(temp);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, result) < 0)
                StdOut.println(key);
        }
    }
}
