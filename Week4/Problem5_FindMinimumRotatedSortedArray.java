public class Problem5_FindMinimumRotatedSortedArray {
    
    int findMin(int[] nums) {
        // Modified binary search
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare mid with right
            if (nums[mid] > nums[right]) {
                // Minimum is in right half
                left = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        Problem5_FindMinimumRotatedSortedArray solution = new Problem5_FindMinimumRotatedSortedArray();
        
        System.out.println("Test 1: [3,4,5,1,2]");
        int result1 = solution.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println("Result: " + result1 + " Expected: 1");
        
        System.out.println("\nTest 2: [4,5,6,7,0,1,2]");
        int result2 = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println("Result: " + result2 + " Expected: 0");
        
        System.out.println("\nTest 3: [11,13,15,17]");
        int result3 = solution.findMin(new int[]{11, 13, 15, 17});
        System.out.println("Result: " + result3 + " Expected: 11");
    }
}
