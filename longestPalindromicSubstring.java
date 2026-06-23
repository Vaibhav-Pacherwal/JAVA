import java.util.*;

public class longestPalindromicSubstring {
    public static int expand(String str, int left, int right) {
        while (left >= 0 && right < str.length()
                && str.charAt(left) == str.charAt(right)) {

            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome(String str) {
        if (str == null || str.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expand(str, i, i);      
            int len2 = expand(str, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return str.substring(start, end + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String:");
        String str = sc.nextLine();

        String ans = longestPalindrome(str.toLowerCase());
        System.out.println(ans);

        sc.close();
    }
}
