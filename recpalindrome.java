public class PalindromeRecursive {
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1);
    }

    public static boolean checkPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""); 
        return isPalindrome(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        String test = "A man, a plan, a canal, Panama";
        System.out.println("\"" + test + "\" is palindrome? " + checkPalindrome(test));
    }
}
