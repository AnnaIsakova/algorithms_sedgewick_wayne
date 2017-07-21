package fundamentals;



//Write a version of BinarySearch that uses the recursive rank() given on page
//        25 and traces the method calls. Each time the recursive method is called, print the argument
//        values lo and hi, indented by the depth of the recursion. Hint: Add an argument
//        to the recursive method that keeps track of the depth.

public class BinarySearch1_1_22 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 7, 19, 20, 48, 55, 234, 654, 985};
        System.out.println(rank(553, arr));
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        System.out.println("lo: " + lo + "; hi: " + hi + "; depth: " + depth);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, depth+1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth+1);
        else return mid;
    }
}
