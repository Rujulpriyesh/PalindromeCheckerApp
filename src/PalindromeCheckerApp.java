import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully");

        // UC2
        String inputUC2 = "madam";
        boolean isPalindromeUC2 = true;

        for (int i = 0; i < inputUC2.length() / 2; i++) {
            if (inputUC2.charAt(i) != inputUC2.charAt(inputUC2.length() - 1 - i)) {
                isPalindromeUC2 = false;
                break;
            }
        }

        System.out.println(inputUC2 + " -> " + isPalindromeUC2);


        // UC3
        String inputUC3 = "level";
        String reversed = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {
            reversed += inputUC3.charAt(i);
        }

        System.out.println(inputUC3 + " reversed = " + reversed);
        System.out.println("Palindrome? " + inputUC3.equals(reversed));


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

        System.out.println(inputUC4 + " -> " + isPalindromeUC4);


        // UC5
        String inputUC5 = "noon";
        Stack<Character> stackUC5 = new Stack<>();

        for (char c : inputUC5.toCharArray())
            stackUC5.push(c);

        boolean isPalindromeUC5 = true;

        for (char c : inputUC5.toCharArray()) {

            if (c != stackUC5.pop()) {
                isPalindromeUC5 = false;
                break;
            }
        }

        System.out.println(inputUC5 + " -> " + isPalindromeUC5);


        // UC6
        String inputUC6 = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (char c : inputUC6.toCharArray()) {
            queue.offer(c);
            stackUC6.push(c);
        }

        boolean isPalindromeUC6 = true;

        while (!queue.isEmpty()) {

            if (!queue.poll().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println(inputUC6 + " -> " + isPalindromeUC6);


        // UC7
        String inputUC7 = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : inputUC7.toCharArray())
            deque.addLast(c);

        boolean isPalindromeUC7 = true;

        while (deque.size() > 1) {

            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println(inputUC7 + " -> " + isPalindromeUC7);


        // UC8
        String inputUC8 = "madam";
        LinkedList<Character> list = new LinkedList<>();

        for (char c : inputUC8.toCharArray())
            list.add(c);

        boolean isPalindromeUC8 = true;

        while (list.size() > 1) {

            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                isPalindromeUC8 = false;
                break;
            }
        }

        System.out.println(inputUC8 + " -> " + isPalindromeUC8);


        // UC9
        String inputUC9 = "madam";
        boolean isPalindromeUC9 = checkRecursive(inputUC9, 0, inputUC9.length() - 1);
        System.out.println(inputUC9 + " -> " + isPalindromeUC9);


        // UC10
        String inputUC10 = "A man a plan a canal Panama";
        String processed = inputUC10.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindromeUC10 = processed.equals(
                new StringBuilder(processed).reverse().toString()
        );

        System.out.println(inputUC10 + " -> " + isPalindromeUC10);


        // UC11
        PalindromeService service = new PalindromeService();
        String inputUC11 = "racecar";
        boolean resultUC11 = service.isPalindrome(inputUC11);
        System.out.println(inputUC11 + " -> " + resultUC11);


        // ==========================
        // UC12 - Strategy Pattern
        // ==========================

        String inputUC12 = "level";

        PalindromeStrategy strategy = new StackStrategy();

        boolean resultUC12 = strategy.check(inputUC12);

        System.out.println(inputUC12 + " -> " + resultUC12);

    }


    private static boolean checkRecursive(String s, int start, int end) {

        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return checkRecursive(s, start + 1, end - 1);
    }
}


// UC11 Service Class
class PalindromeService {

    public boolean isPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}


// UC12 Strategy Interface
interface PalindromeStrategy {

    boolean check(String input);
}


// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray())
            stack.push(c);

        for (char c : input.toCharArray()) {

            if (c != stack.pop())
                return false;
        }

        return true;
    }
}