public class Problem5_MovieReviewWordLengthProfiler {
    
    void classifyWordLengths(String review) {
        String[] words = review.split(" ");
        
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;
        
        for (String word : words) {
            int length = word.length();
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }
        
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
    
    public static void main(String[] args) {
        Problem5_MovieReviewWordLengthProfiler profiler = new Problem5_MovieReviewWordLengthProfiler();
        
        System.out.println("Test 1: Movie review classification");
        profiler.classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
