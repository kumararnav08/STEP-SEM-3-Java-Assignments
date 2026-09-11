public class Problem2_MaximumSubarray {
    
    int maxSubArray(int[] nums) {
        // Kadane's algorithm
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Choose whether to extend current subarray or restart
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            // Update global maximum
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        
        return maxGlobal;
    }
    
    public static void main(String[] args) {
        Problem2_MaximumSubarray solution = new Problem2_MaximumSubarray();
        
        System.out.println("Test 1: [-2,1,-3,4,-1,2,1,-5,4]");
        int result1 = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("Result: " + result1 + " Expected: 6");
        
        System.out.println("\nTest 2: [-3,-1,-2]");
        int result2 = solution.maxSubArray(new int[]{-3, -1, -2});
        System.out.println("Result: " + result2 + " Expected: -1");
    }
}
