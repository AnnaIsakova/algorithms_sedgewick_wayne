package fundamentals;



//   Add to BinarySearch a static method rank() that takes a key and
//        a sorted array of int values (some of which may be equal) as arguments and returns the
//        number of elements that are smaller than the key and a similar method count() that
//        returns the number of elements equal to the key. Note : If i and j are the values returned
//        by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
//        the array that are equal to key.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class EqualKeys1_1_29 {
    public static int search(int key, int[] a)
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

    //returns number of all elements, that are smaller than key, even if some of those elements are equal
    public static int rank(int key, int[] a){
        int index = search(key, a);
        for (int i = index; i >= 0 ; i--) {
            if (a[i] < key){
                return i + 1;
            }
        }
        return -1;
    }

    public static int count(int key, int[] a){
        int index = search(key, a);
        int count = 0;
        for (int i = index; i >= 0 ; i--) {
            if (a[i] < key) break;
            else count++;
        }
        for (int i = index+1; i < a.length ; i++) {
            if (a[i] > key) break;
            else count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] whitelist = {0, 2, 3,1,3,3,3,3,3,4};
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (search(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}
