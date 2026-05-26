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

    public static boolean checkDuplicate(int nums[]) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        if(ans == 0) {
            return false;
        }

        return true;
    }

    public static int buyAndSell(int nums[]) {
        int bestBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < bestBuy) {
                bestBuy = nums[i];
            } else {
                maxProfit = Math.max(maxProfit, nums[i]-bestBuy);
            }
        }

        return maxProfit;
    }

    public static int waterStored(int nums[]) {
        //Auxilary Arrays - leftBounds & rightBounds
        int currBound1 = Integer.MIN_VALUE;
        int leftBounds[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > currBound1) {
                currBound1 = nums[i];
            }
            leftBounds[i] = currBound1;
        } 

        int currBound2 = Integer.MIN_VALUE;
        int rightBounds[] = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
            if(nums[i] > currBound2) {
                currBound2 = nums[i];
            }
            rightBounds[i] = currBound2;
        } 

        int maxWaterStored = 0;
        for(int i = 0; i < nums.length; i++) {
            int bound = Math.min(leftBounds[i], rightBounds[i]);
            maxWaterStored += bound-nums[i];
        }

        return maxWaterStored;
    }

    public static int[][] getTriplets(int nums[]) {
        Set<List<Integer>> triplets = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int sum = 0;
                for(int k = j+1; k < nums.length; k++) {
                    sum = nums[i]+nums[j]+nums[k];
                    if(sum == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        triplets.add(temp);
                    }
                } 
            } 
        }

        int result[][] = new int[triplets.size()][3];
        int row = 0;
        for(List<Integer> triplet : triplets) {
            for(int col = 0; col < 3; col++) {
                result[row][col] = triplet.get(col);
            }
            row++;
        } 

        return result;
    }

    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            int j = 0, k = 1;
            while(k < nums.length) {
                if(nums[j] > nums[k]) {
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                }
                j++;
                k++;
            }
        }
    }

    public static void selectionSort(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int j = i, k = i-1;
            while(k >= 0) {
                if(nums[j] < nums[k]) {
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                }
                j--;
                k--;
            }
        }
    }

    public static void countingSort(int[] nums) {
        int count[] = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                nums[index] = i;
                count[i]--;
                index++;
            }
        }
    }

    public static void sortColors(int nums[]) {
        int p = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        for(int i = p; i < nums.length; i++) {
            if(nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        for(int i = p; i < nums.length; i++) {
            if(nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }

    //Brute Force
    public static int[][] threeSum(int nums[]) {
        HashSet<List<Integer>> triplets = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            } 
        }

        int row = 0;
        int result[][] = new int[triplets.size()][3];
        for(List<Integer> triplet: triplets) {
            for(int col = 0; col < 3; col++) {
                result[row][col] = triplet.get(col);
            }
            row++;
        }

        return result;
    }

    //Better - Hashing
    public static List<List<Integer>> threeSum2(int nums[]) {
        HashSet<List<Integer>> triplets = new HashSet<>();
        
        for(int i = 0; i < nums.length-1; i++) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = i+1; j < nums.length; j++) {
                int target = -(nums[i]+nums[j]);
                if(map.containsKey(target)) {
                    List<Integer> triplet = Arrays.asList(nums[i],nums[j],target);
                    Collections.sort(triplet);
                    triplets.add(triplet);
                }
                map.put(nums[j], j);
            }
        }

        List<List<Integer>> list = new ArrayList<>(triplets);
        return list;
    }

    //Optimal Approach
    public static List<List<Integer>> threeSum3(int nums[]) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while(j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return triplets;
    }

    public static List<List<Integer>> fourSum(int nums[], int target) {
        List<List<Integer>> quadruples = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = nums.length-1;
                while(k < l) {
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum < target) {
                        k++;
                    } else if(sum > target) {
                        l--;
                    } else {
                        quadruples.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;

                        while(k < l && nums[k] == nums[k-1]) {
                            k++;
                        }

                        while(k < l && nums[l] == nums[l+1]) {
                            l--;
                        }
                    }
                }
            }
        }

        return quadruples;
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

        // int heights[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        // int trappedWater = waterStored(heights);
        // System.out.println("Trapped Water:" + trappedWater);

        // int nums[][] = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        // int response[] = new int[2];
        // response = repeatedAndMissing(nums);
        // System.out.print(response[0] + "," + response[1]);

        // int nums1[] ={1, 2, 3, 0, 0, 0};
        // int nums2[] = {2, 5, 6}; 
        // mergeSortedArray(nums1, nums2, 3, 3);
        // for(int i = 0; i < nums1.length; i++) {
        //     System.out.print(nums1[i] + " ");
        // }

        int nums[] = {2,2,2,2,2};
        List<List<Integer>> triplets = fourSum(nums, 8);
        for(List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        // Integer nums[] = {647,342,324,234,234,342};
        // // insertionSort(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println(nums[0]);

        // int nums[] = { 2,0,2,1,1,0 };
        // sortColors(nums);
        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }


        sc.close();
    }
}
