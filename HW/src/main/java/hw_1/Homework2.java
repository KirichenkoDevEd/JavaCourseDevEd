package hw_1;

import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) {
        System.out.println("Enter numbers '1','2' or '3':");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        answer(num);
    }

    public static String answer(int num) {
        String answer;
        answer = num == 1 || num == 2 || num == 3 ? "You have entered number: " + num : "You have entered wrong number! Please try again.";
        System.out.println(answer);
        return answer;
    }
}
