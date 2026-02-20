public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 : Application Entry & Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        // UC2 : Hardcoded Palindrome Check

        String input = "madam";

        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {

            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {

                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {

            System.out.println(input + " is a Palindrome");

        } else {

            System.out.println(input + " is not a Palindrome");

        }
    }
}