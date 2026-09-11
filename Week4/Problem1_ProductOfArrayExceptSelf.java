public class Problem1_ProductOfArrayExceptSelf {
    
    int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // First pass: calculate products to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Second pass: calculate products to the right and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Problem1_ProductOfArrayExceptSelf solution = new Problem1_ProductOfArrayExceptSelf();
        
        System.out.println("Test 1: [1,2,3,4]");
        int[] result1 = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println("Expected: [24, 12, 8, 6]");
        
        System.out.println("\nTest 2: [-1,1,0,-3,3]");
        int[] result2 = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println("Expected: [0, 0, 9, 0, 0]");
    }
}
