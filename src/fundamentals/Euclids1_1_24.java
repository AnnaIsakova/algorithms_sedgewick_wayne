package fundamentals;


//Give the sequence of values of p and q that are computed when Euclid’s algorithm
//        is used to compute the greatest common divisor of 105 and 24. Extend the code
//        given on page 4 to develop a program Euclid that takes two integers from the command
//        line and computes their greatest common divisor, printing out the two arguments for
//        each call on the recursive method. Use your program to compute the greatest common
//        divisor or 1111111 and 1234567.

import java.util.Scanner;

public class Euclids1_1_24 {
    public static void main(String[] args) {
        int[] input = getInput();
        System.out.println(gcd(input[0], input[1]));
    }

    public static int gcd(int p, int q){
        System.out.println("p => " + p + "; q => " + q);
        if (q == 0) return p;
        int rem = p % q;
        return gcd(q, rem);
    }

    public static int[] getInput(){
        int[] input = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        input[0] = scanner.nextInt();
        System.out.print("Enter second integer: ");
        input[1] = scanner.nextInt();
        return input;
    }
}
