import java.util.HashMap;

public class Problem4_SubarraySumEqualsK {
    
    int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        
        // Initialize with empty prefix
        sumFrequency.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            // Check if there's a prefix such that currentSum - prefix = k
            int target = currentSum - k;
            if (sumFrequency.containsKey(target)) {
                count += sumFrequency.get(target);
            }
            
            // Add current sum to frequency map
            sumFrequency.put(currentSum, sumFrequency.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Problem4_SubarraySumEqualsK solution = new Problem4_SubarraySumEqualsK();
        
        System.out.println("Test 1: nums = [1,1,1], k = 2");
        int result1 = solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println("Result: " + result1 + " Expected: 2");
        
        System.out.println("\nTest 2: nums = [1,-1,0], k = 0");
        int result2 = solution.subarraySum(new int[]{1, -1, 0}, 0);
        System.out.println("Result: " + result2 + " Expected: 3");
    }
}
