import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        
        // best[i] stores the minimum length of a valid sub-array in arr[0...i]
        int[] best = new int[arr.length];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        for (int l = 0, r = 0; r < arr.length; ++r) {
            sum += arr[r];
            
            // Shrink the window if the sum exceeds target
            while (sum > target) {
                sum -= arr[l++];
            }
            
            // If we found a valid sub-array matching the target
            if (sum == target) {
                // Check if a non-overlapping valid sub-array exists to the left
                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[l - 1] + (r - l + 1));
                }
                // Record the length of the current valid sub-array
                best[r] = r - l + 1;
            }
            
            // Propagate the minimum length forward
            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}