import java.util.Scanner;

public class majoritySubarray {
    public static int countMajoritySubarrays(int[] nums, int target) {
        int occ = 0;
        int[] prefixSum = new int[nums.length];
        System.out.println(prefixSum.length);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                occ++;
            }
            prefixSum[i] = occ;
        }

        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int n = j-i+1;
                if(
                    i == 0 && prefixSum[j] > n/2
                    || i > 0 && prefixSum[j]-prefixSum[i-1] > n/2
                ) {
                    ans++;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = {1,2,2,3};
        System.out.print("Enter Target:");
        int target = sc.nextInt();
        int ans = countMajoritySubarrays(nums, target);
        System.out.println(ans);

        sc.close();
    }
}
