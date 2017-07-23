package fundamentals;


//Write a program that takes as command-line arguments
//        an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size
//        .05 on the circumference of a circle, and then, with probability p for each pair of points,
//        draws a gray line connecting them.

import edu.princeton.cs.algs4.StdDraw;

import java.util.Random;

public class RandomConnections1_1_31 {
    public static void main(String[] args) {
        int N = 8;
        double probability = 0.5;
        drawLines(probability, N);
    }

    private static double[][] createCircle(int N){
        //circle with radius = 1;
        double[][] points = new double[N][2];

        double degree = 360/N;
        double x;
        double y;

        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);

        double angle = degree;

        for (int i = 0; i < N; i++) {
            x = Math.cos(Math.toRadians(angle));
            y = Math.sin(Math.toRadians(angle));
            angle += degree;
            points[i][0] = x;
            points[i][1] = y;
        }

        return points;
    }

    private static void drawPoints(double[][] points){
        for (int i = 0; i < points.length; i++) {
            StdDraw.point(points[i][0], points[i][1]);
        }
    }

    public static void drawLines(double p, int N){
        double[][] points = createCircle(N);
        drawPoints(points);
        Random rand = new Random();

        for (int i = 0; i < points.length; i++) {
            for (int j = points.length-1; j > i; j--) {
                if (rand.nextDouble() < p){
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
    }
}
