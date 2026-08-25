class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        long total = 0;
        for (int num : nums) {
            total += num;
        }

        long prefix = 0;

        for (int i = 0; i < n; i++) {
            long x = nums[i];

            // Contribution from elements to the left
            long left = x * i - prefix;

            // Contribution from elements to the right
            long right = (total - prefix - x)
                       - x * (n - i - 1);

            result[i] = (int) (left + right);

            prefix += x;
        }

        return result;
    }
}