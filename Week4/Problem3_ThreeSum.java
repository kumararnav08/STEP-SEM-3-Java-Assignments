import java.util.Arrays;

public class Problem3_ThreeSum {
    
    int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        java.util.List<int[]> result = new java.util.ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Two pointer approach for remaining elements
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Skip duplicate left elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate right elements
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result.toArray(new int[0][]);
    }
    
    public static void main(String[] args) {
        Problem3_ThreeSum solution = new Problem3_ThreeSum();
        
        System.out.println("Test 1: [-1,0,1,2,-1,-4]");
        int[][] result1 = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (int[] triplet : result1) {
            System.out.println(Arrays.toString(triplet));
        }
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]");
        
        System.out.println("\nTest 2: [0,0,0]");
        int[][] result2 = solution.threeSum(new int[]{0, 0, 0});
        for (int[] triplet : result2) {
            System.out.println(Arrays.toString(triplet));
        }
        System.out.println("Expected: [[0,0,0]]");
    }
}
