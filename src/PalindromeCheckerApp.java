import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        // UC2
        String inputUC2 = "madam";

        boolean isPalindromeUC2 = true;

        for (int i = 0; i < inputUC2.length() / 2; i++) {

            if (inputUC2.charAt(i) != inputUC2.charAt(inputUC2.length() - 1 - i)) {

                isPalindromeUC2 = false;
                break;
            }
        }

        System.out.println(inputUC2 +
                (isPalindromeUC2 ? " is a Palindrome" : " is not a Palindrome"));


        // UC3

        String inputUC3 = "level";

        String reversed = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {

            reversed += inputUC3.charAt(i);

        }

        boolean isPalindromeUC3 = inputUC3.equals(reversed);

        System.out.println("Input : " + inputUC3);
        System.out.println("Reversed : " + reversed);
        System.out.println("Is Palindrome? : " + isPalindromeUC3);


        // UC4

        String inputUC4 = "radar";

        char[] chars = inputUC4.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        boolean isPalindromeUC4 = true;

        while (start < end) {

            if (chars[start] != chars[end]) {

                isPalindromeUC4 = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input : " + inputUC4);
        System.out.println("Is Palindrome? : " + isPalindromeUC4);


        // UC5

        String inputUC5 = "noon";

        Stack<Character> stackUC5 = new Stack<>();

        for (char c : inputUC5.toCharArray()) {

            stackUC5.push(c);
        }

        boolean isPalindromeUC5 = true;

        for (char c : inputUC5.toCharArray()) {

            if (c != stackUC5.pop()) {

                isPalindromeUC5 = false;
                break;
            }
        }

        System.out.println("Input : " + inputUC5);
        System.out.println("Is Palindrome? : " + isPalindromeUC5);


        // ==========================
        // UC6 Queue + Stack Method
        // ==========================

        String input = "civic";

        Queue<Character> queue = new LinkedList<>();

        Stack<Character> stack = new Stack<>();

        // insert into both
        for (char c : input.toCharArray()) {

            queue.offer(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {

            if (!queue.poll().equals(stack.pop())) {

                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

    }
}