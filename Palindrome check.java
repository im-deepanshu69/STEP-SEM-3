import java.util.Scanner;

public class PalindromeChecker {

    // Method 1: Iterative Approach
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 2: Recursive Approach
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Method 3: Array Reversal Approach
    public static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        int j = 0;
        for (int i = original.length - 1; i >= 0; i--) {
            reversed[j++] = original[i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.next();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean array = isPalindromeArrayReversal(text);

        System.out.println("\nResults:");
        System.out.println("Iterative : " + (iterative ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive : " + (recursive ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal : " + (array ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}