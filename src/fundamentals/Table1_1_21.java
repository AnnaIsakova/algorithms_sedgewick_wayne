package fundamentals;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Write a program that reads in lines from standard input with each line containing
//        a name and two integers and then prints a table with a column of
//        the names, the integers, and the result of dividing the first by the second, accurate to
//        three decimal places. You could use a program like this to tabulate batting averages for
//        baseball players or grades for students.
public class Table1_1_21 {
    public static void main(String[] args) {
        List<String[]> list = getInput();
        printTable(list);
    }

    public static List<String[]> getInput(){
        List<String[]> inputList = new ArrayList<>();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            String[] oneInput = input.split(" ");
            if (oneInput.length == 3 && oneInput[1].matches("^-?\\d+$") && oneInput[2].matches("^-?\\d+$")){
                inputList.add(oneInput);
            } else {
                System.out.println("invalid input, try again!");
            }
        }
        return inputList;
    }

    public static void printTable(List<String[]> list){
        String name;
        double first;
        double second;
        double result;
        for (String[] arr:list) {
            name = arr[0];
            try {
                first = Double.parseDouble(arr[1]);
                second = Double.parseDouble(arr[2]);
                result = first / second;
                System.out.printf("%s %.3f %.3f %.3f\r\n", name, first, second, result);
            } catch (NumberFormatException e){
                System.out.println("Oops");
            }
        }
    }
}
