import java.util.HashMap;
import java.util.Scanner;

public class LSWR {
    public static int longestSubstring(String str) {
        if(str.length() == 1) {
            return 1;
        }

        int maxL = 0;
        for(int j = 0; j < str.length(); j++) {
            int currL = 1;
            char curr = str.charAt(j);
            for(int i = j+1; i < str.length(); i++) {
                if(str.charAt(i) != curr) {
                    currL++;
                    curr = str.charAt(i);
                } else {
                    currL = 1;
                    curr = str.charAt(i);
                }
                maxL = Integer.max(currL, maxL);
            }
        }

        return maxL;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String:");
        String str = sc.nextLine();
        System.out.println(longestSubstring(str));

        sc.close();
    }
}
