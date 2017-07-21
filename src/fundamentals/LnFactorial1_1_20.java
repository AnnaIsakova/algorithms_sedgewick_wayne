package fundamentals;



//Write a recursive static method that computes the value of ln (N !)
public class LnFactorial1_1_20 {
    public static void main(String[] args) {
        System.out.println(Math.log(ln(8)));
    }

    public static double ln(int n){
        if (n < 2){
            return 1;
        }
        return n * ln(n-1);
    }
}
