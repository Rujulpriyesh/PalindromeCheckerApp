import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        // UC2 Hardcoded Palindrome
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


        // UC3 Reverse String Method

        String inputUC3 = "level";

        String reversed = "";

        for (int i = inputUC3.length() - 1; i >= 0; i--) {

            reversed = reversed + inputUC3.charAt(i);

        }

        boolean isPalindromeUC3 = inputUC3.equals(reversed);

        System.out.println("Input : " + inputUC3);
        System.out.println("Reversed : " + reversed);
        System.out.println("Is Palindrome? : " + isPalindromeUC3);


        // UC4 Character Array Method

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


        // ==========================
        // UC5 Stack Based Palindrome
        // ==========================

        String input = "noon";

        Stack<Character> stack = new Stack<>();

        // push characters
        for (char c : input.toCharArray()) {

            stack.push(c);
        }

        boolean isPalindrome = true;

        // compare pop order
        for (char c : input.toCharArray()) {

            if (c != stack.pop()) {

                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

    }
}