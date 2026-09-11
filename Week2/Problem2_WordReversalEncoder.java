public class Problem2_WordReversalEncoder {
    
    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            result.append(reversed.reverse());
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Problem2_WordReversalEncoder encoder = new Problem2_WordReversalEncoder();
        
        System.out.println("Test 1: Reverse each word");
        String result1 = encoder.reverseEachWord("hello club");
        System.out.println(result1);
        
        System.out.println("\nTest 2: Single word");
        String result2 = encoder.reverseEachWord("hello");
        System.out.println(result2);
    }
}
