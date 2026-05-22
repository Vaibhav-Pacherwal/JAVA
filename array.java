import java.util.*;

public class array {
    public static int linearSearch(int nums[], int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int largestNum(int nums[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int binarySearch(int nums[], int target) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static void reverseArray(int nums[]) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void pairs(int nums[]) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                System.out.print(nums[i] + "," + nums[j] + " ");
            }
            System.out.println();
        }
    }

    public static void subArrays(int nums[]) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //Brute Force
    public static int maxSubArraySum_1(int nums[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //Better - Prefix Sum
    public static int maxSubArraySum_2(int nums[]) {
        int prefixSum = 0;
        int prefix[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefix[i] = prefixSum;
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int start = i;
            for(int j = i; j < nums.length; j++) {
                int end = j;
                int currSum = start == 0 ? prefix[end] : prefix[end]-prefix[start-1];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    public static int maxSubArraySum_3(int nums[]) {
        boolean flag = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                flag = false;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        if(!flag) {
            int currSum = 0;
            for(int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                if(currSum < 0) {
                    currSum = 0;
                }
                maxSum = Math.max(currSum, maxSum);
            }
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] > maxSum) {
                    maxSum = nums[i];
                }
            }
        }

        return maxSum;
    }

    public static int trappedRainWater(int heights[]) {
        int maxLeftHeight = Integer.MIN_VALUE;
        int leftBounds[] = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] > maxLeftHeight) {
                maxLeftHeight = heights[i];
            }
            leftBounds[i] = maxLeftHeight;
        }

        int maxRightHeight = Integer.MIN_VALUE;
        int rightBounds[] = new int[heights.length];
        for(int i = heights.length-1; i >= 0; i--) {
            if(heights[i] > maxRightHeight) {
                maxRightHeight = heights[i];
            }
            rightBounds[i] = maxRightHeight;
        }

        int trappedWater = 0;
        for(int i = 0; i < heights.length; i++) {
            int bound = Math.min(leftBounds[i], rightBounds[i]);
            trappedWater += bound-heights[i];
        }

        return trappedWater;
    }

    public static int[] repeatedAndMissing(int nums[][]) {
        int m = nums.length, n = nums[0].length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                freq.put(nums[i][j], freq.getOrDefault(nums[i][j], 0) + 1);
            }
        }

        int repeatedValue = -1;
        for(Integer key : freq.keySet()) {
            if(freq.get(key) == 2) {
                repeatedValue = key;
            }
        }

        int missingValue = -1;
        for(int i = 0; i < m*n; i++) {
            if(freq.get(i+1) == null) {
                missingValue = i+1;
            }
        }

        return new int[] {repeatedValue, missingValue};
    } 

    public static void mergeSortedArray(int nums1[], int nums2[], int m, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        if(j >= 0) {
            while(k >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int nums[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int target = sc.nextInt();
        // int idx = linearSearch(nums, target);
        // if(idx != -1) {
        //     System.out.println("Target is at index " + idx);
        // } else {
        //     System.out.println("Target not found");
        // }

        // int nums[] = {1, 2, 6, 3, 5};
        // int largest = largestNum(nums);
        // System.out.println("Max in nums:" + largest);

        // int nums[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int target = sc.nextInt();
        // int idx = binarySearch(nums, target);
        // if(idx != -1) {
        //     System.out.println("Target is at index " + idx);
        // } else {
        //     System.out.println("Target not found");
        // }

        // int nums[] = {2, 4, 6, 8, 10};
        // reverseArray(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }

        // int nums[] = {2, 4, 6, 8, 10};
        // pairs(nums);
        // subArrays(nums);

        // int heights[] = {4, 2, 0, 6, 3, 2, 5};
        // int trappedWater = trappedRainWater(heights);
        // System.out.println("Trapped Water:" + trappedWater);

        // int nums[][] = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        // int response[] = new int[2];
        // response = repeatedAndMissing(nums);
        // System.out.print(response[0] + "," + response[1]);

        int nums1[] ={1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6}; 
        mergeSortedArray(nums1, nums2, 3, 3);
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }

        sc.close();
    }
}
