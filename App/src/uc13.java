import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return str.equals(reversed);
    }

    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        endTime = System.nanoTime();
        System.out.println("Stack Approach: " + stackResult + " | Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        endTime = System.nanoTime();
        System.out.println("Deque Approach: " + dequeResult + " | Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(input);
        endTime = System.nanoTime();
        System.out.println("Two Pointer Approach: " + twoPointerResult + " | Time: " + (endTime - startTime) + " ns");
    }
}
