public class Problem2_TypingAccuracyChecker {
    
    void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1;
        char originalChar = ' ';
        char typedChar = ' ';
        
        // Compare character by character
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i;
                    originalChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }
        
        // Calculate accuracy
        double accuracy = ((double) matched / original.length()) * 100;
        
        // Print result
        System.out.print("Matched: " + matched + "/" + original.length());
        System.out.printf(" | Accuracy: %.2f%%", accuracy);
        
        if (firstMismatchPos == -1) {
            System.out.println(" | No Mismatches");
        } else {
            // Use 1-based position numbering
            System.out.println(" | First Mismatch at position " + (firstMismatchPos + 1) + " ('" + originalChar + "' vs '" + typedChar + "')");
        }
    }
    
    public static void main(String[] args) {
        Problem2_TypingAccuracyChecker checker = new Problem2_TypingAccuracyChecker();
        
        System.out.println("Test 1: Mismatch at position 11");
        checker.checkTypingAccuracy("hello world", "hello worlt");
        
        System.out.println("\nTest 2: Perfect match");
        checker.checkTypingAccuracy("coding", "coding");
    }
}