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


        // ==========================
        // UC3 Reverse String Method
        // ==========================

        String input = "level";

        String reversed = "";

        // reverse loop (PDF hint)
        for (int i = input.length() - 1; i >= 0; i--) {

            reversed = reversed + input.charAt(i);

        }

        boolean isPalindrome = input.equals(reversed);

        System.out.println("Input : " + input);
        System.out.println("Reversed : " + reversed);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}