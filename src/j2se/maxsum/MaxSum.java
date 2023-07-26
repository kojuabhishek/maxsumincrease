package j2se.maxsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSum {

    static List<Integer> findMaxSumIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prevIndex = new int[n];

 
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            prevIndex[i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
                    dp[i] = dp[j] + nums[i];
                    prevIndex[i] = j;
                }
            }
        }

      
        int maxSumIndex = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxSumIndex]) {
                maxSumIndex = i;
            }
        }

       
        List<Integer> subsequence = new ArrayList<>();
        int currentIndex = maxSumIndex;
        while (currentIndex != prevIndex[currentIndex]) {
            subsequence.add(nums[currentIndex]);
            currentIndex = prevIndex[currentIndex];
        }
        subsequence.add(nums[currentIndex]);

        return subsequence;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        List<Integer> subsequence = findMaxSumIncreasingSubsequence(nums);
        int maxSum = subsequence.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Maximum sum : " + maxSum);
        System.out.println("The subsequence is: " + subsequence);
    }
}
