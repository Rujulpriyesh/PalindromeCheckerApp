import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ==========================
        // UC1 - Welcome Message
        // ==========================
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully");


        // ==========================
        // UC2 - Hardcoded Palindrome
        // ==========================
        String inputUC2 = "madam";
        boolean isPalindromeUC2 = true;

        for (int i = 0; i < inputUC2.length() / 2; i++) {
            if (inputUC2.charAt(i) != inputUC2.charAt(inputUC2.length() - 1 - i)) {
                isPalindromeUC2 = false;
                break;
            }
        }

        System.out.println("UC2: " + inputUC2 + " -> " + isPalindromeUC2);


        // ==========================
        // UC3 - Reverse String
        // ==========================
        String inputUC3 = "level";
        String reversed = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {
            reversed += inputUC3.charAt(i);
        }

        System.out.println("UC3: " + inputUC3 + " -> " + inputUC3.equals(reversed));


        // ==========================
        // UC4 - Character Array
        // ==========================
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

        System.out.println("UC4: " + inputUC4 + " -> " + isPalindromeUC4);


        // ==========================
        // UC5 - Stack
        // ==========================
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

        System.out.println("UC5: " + inputUC5 + " -> " + isPalindromeUC5);


        // ==========================
        // UC6 - Queue + Stack
        // ==========================
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

        System.out.println("UC6: " + inputUC6 + " -> " + isPalindromeUC6);


        // ==========================
        // UC7 - Deque
        // ==========================
        String inputUC7 = "refer";

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : inputUC7.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeUC7 = true;

        while (deque.size() > 1) {

            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println("UC7: " + inputUC7 + " -> " + isPalindromeUC7);


        // ==========================
        // UC8 - Linked List
        // ==========================
        String inputUC8 = "madam";

        LinkedList<Character> list = new LinkedList<>();

        for (char c : inputUC8.toCharArray()) {
            list.add(c);
        }

        boolean isPalindromeUC8 = true;

        while (list.size() > 1) {

            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                isPalindromeUC8 = false;
                break;
            }
        }

        System.out.println("UC8: " + inputUC8 + " -> " + isPalindromeUC8);


        // ==========================
        // UC9 - Recursive
        // ==========================
        String inputUC9 = "madam";

        boolean isPalindromeUC9 = checkRecursive(inputUC9, 0, inputUC9.length() - 1);

        System.out.println("UC9: " + inputUC9 + " -> " + isPalindromeUC9);


        // ==========================
        // UC10 - Ignore Case & Spaces
        // ==========================
        String inputUC10 = "A man a plan a canal Panama";

        String processed = inputUC10.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindromeUC10 =
                processed.equals(new StringBuilder(processed).reverse().toString());

        System.out.println("UC10: " + inputUC10 + " -> " + isPalindromeUC10);


        // ==========================
        // UC11 - OOP Service
        // ==========================
        PalindromeService service = new PalindromeService();

        String inputUC11 = "racecar";

        boolean resultUC11 = service.isPalindrome(inputUC11);

        System.out.println("UC11: " + inputUC11 + " -> " + resultUC11);


        // ==========================
        // UC12 - Strategy Pattern
        // ==========================
        String inputUC12 = "level";

        PalindromeStrategy strategy = new StackStrategy();

        boolean resultUC12 = strategy.check(inputUC12);

        System.out.println("UC12: " + inputUC12 + " -> " + resultUC12);


        // ==========================
        // UC13 - Performance Comparison
        // ==========================
        String inputUC13 = "racecar";

        long start1 = System.nanoTime();
        boolean recursiveResult = checkRecursive(inputUC13, 0, inputUC13.length() - 1);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean serviceResult = service.isPalindrome(inputUC13);
        long end2 = System.nanoTime();

        System.out.println("UC13 Recursive Result: " + recursiveResult);
        System.out.println("Recursive Time: " + (end1 - start1));

        System.out.println("UC13 Service Result: " + serviceResult);
        System.out.println("Service Time: " + (end2 - start2));

    }


    // Recursive method
    private static boolean checkRecursive(String s, int start, int end) {

        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return checkRecursive(s, start + 1, end - 1);
    }
}


// ==========================
// UC11 Service Class
// ==========================
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


// ==========================
// UC12 Strategy Interface
// ==========================
interface PalindromeStrategy {

    boolean check(String input);
}


// ==========================
// Stack Strategy
// ==========================
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