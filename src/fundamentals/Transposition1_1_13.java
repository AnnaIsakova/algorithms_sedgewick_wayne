package fundamentals;


//Write a code fragment to print the transposition (rows and columns changed)
//        of a two-dimensional array with M rows and N columns.

public class Transposition1_1_13 {
    public static void main(String[] args) {
        int[][] array = new int[7][6];

        //filling array
        int step = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = step+i+j;
                System.out.print(array[i][j] + " ");
            }
            step += 10;
            System.out.println();
        }

        System.out.println("--------------");

        //printing transposition of array
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }

    }
}
