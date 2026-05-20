import java.util.*;

public class init {
    public static int fact(int num) {
        int ans = 1;
        while(num > 0) {
            ans *= num;
            num--;
        }

        return ans;
    }

    public static void evenNumbersInRange(int start, int end) {
        while(start < end) {
            if(start%2 == 0) {
                System.out.print(start + " ");
            }
            if(end%2 == 0) {
                System.out.print(end + " ");
            }

            start++;
            end--;
        }
    }

    public static void table(int num) {
        int ans = 1;
        while(ans <= 10) {
            System.out.print(ans*num + " ");
            ans++;
        }
    }

    public static int reverseNumber(int num) {
        int ans = 0;
        while(num > 0) {
            int digit = num%10;
            ans *= 10;
            ans += digit;
            num /= 10;
        }

        return ans;
    }

    public static int digitCount(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num /= 10;
        }

        return count;
    }

    public static int digitSum(int num) {
        int sum = 0;
        while(num > 0) {
            int digit = num%10;
            sum += digit;
            num /= 10;
        }

        return sum;
    }

    public static boolean isNumberPalindrome(int num) {
        int ans = 0;
        int backupNum = num;
        while(num > 0) {
            int digit = num%10;
            ans *= 10;
            ans += digit;
            num /= 10;
        }

        return (ans == backupNum);
    }

    public static boolean isArmstrong(int num) {
        int sum = 0;
        int backupNum = num;
        while(num > 0) {
            int digit = num%10;
            sum += Math.pow(digit, 3);
            num /= 10;
        }

        return (sum == backupNum);
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i < num-1; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        int i = 1;
        int commonDivisor = 0;
        while(i <= Math.min(a, b)) {
            if(a%i==0 && b%i==0) {
                commonDivisor = i;
            }
            i++;
        }

        return commonDivisor;
    }

    public static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }

    public static boolean isStrong(int num) {
        int factSum = 0;
        int backupNum = num;
        while(num > 0) {
            int digit = num%10;
            factSum += fact(digit);
            num /= 10;
        }

        return (factSum == backupNum);
    }

    public static void patt_1(int rows) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt_2(int rows) {
        for(int i = rows; i > 0; i--) {
            for(int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt_3(int rows) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    public static void patt_4(int rows) {
        char ch = 'A';
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

    public static void patt_5(int rows) {
        for(int j = 0; j < rows; j++) {
            System.out.print("*");
        }
        System.out.println();

        for(int i = 0; i < rows-2; i++) {
            for(int j = 0; j < rows; j++) {
                if(j == 0 || j == rows-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int j = 0; j < rows; j++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void patt_6(int rows) {
        for(int i = rows; i > 0; i--) {
            for(int j = i; j > 0; j--) {
                System.out.print(" ");
            }

            for(int j = i; j <= rows; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void patt_7(int rows) {
        int num = 1;
        for(int i = rows; i > 0; i--) {
            for(int j = i; j > 0; j--) {
                System.out.print(" ");
            }

            for(int j = i; j <= rows; j++) {
                System.out.print(num);
                num++;
            }

            System.out.println();
        }
    }

    public static void patt_8(int rows) {
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void patt_9(int rows) {
        int flag = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(flag);
                if(flag == 1) {
                    flag = 0;
                } else {
                    flag = 1;
                }
            }
            System.out.println();
        }
    }

    public static void patt_10(int rows) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for(int j = 2; j < 2*(rows-i); j++) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = rows; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for(int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt_11(int rows) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt_12(int rows) {
        for(int i = 0; i < rows; i++) {
            for(int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patt_13(int rows) {
        for(int i = 0; i < rows; i++) {
            for(int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < rows; j++) {
                if(i == 0 || i == rows-1) {
                    System.out.print("*");
                } else {
                    if(j == 0 || j == rows-1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void patt_14(int rows) {
        for(int i = 1; i <= rows; i++) {
            for(int j = rows; j >= i; j--) {
                System.out.print(" ");
            }
            for(int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = rows; i > 0; i--) {
            for(int j = rows; j >= i; j--) {
                System.out.print(" ");
            }
            for(int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // System.out.print("enter rows:");
        // int rows = sc.nextInt();
        // patt_14(rows);

        // System.out.println("Factorial of " + num + ":" + fact(num));

        // evenNumbersInRange(10, 20);
        // table(5);
        // System.out.println(reverseNumber(6342384));
        // System.out.println(digitSum(6348723));
        // if(isStrong(145)) {
        //     System.out.println("strong");
        // } else {
        //     System.out.println("not strong");
        // }
        // System.out.println(lcm(12, 18));

        sc.close();
    }
}
