package fundamentals;



//Write a code fragment that creates an N-by-N boolean array
//        a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors),
//        and false otherwise.

public class ArrayExercise1_1_30 {
    public static void main(String[] args) {
        boolean[][] arr = getArr(5);
        printArray(arr);
    }

    public static int gcd(int p, int q){
        if (q == 0) return p;
        return gcd(q, p%q);
    }

    public static boolean[][] getArr(int n){
        boolean[][] result = new boolean[n][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (gcd(i, j) == 1){
                    result[i][j] = true;
                }
            }
        }
        return result;
    }

    public static void printArray(boolean[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]){
                    System.out.print(i + " " + j + " " + array[i][j] + "  ");
                } else {
                    System.out.print(i + " " + j + " " + array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
