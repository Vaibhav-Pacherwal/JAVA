import java.util.*;

public class stringCompression {
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        
        int count = 1;
        char currChar = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == currChar) {
                count++;
            } else {
                sb.append(currChar);
                sb.append(count);
                count = 1;
                currChar = str.charAt(i);
            }
        }
        sb.append(currChar);
        sb.append(count);

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String:");
        String str = sc.nextLine();
        System.out.println(compress(str));

        sc.close();
    }
}
