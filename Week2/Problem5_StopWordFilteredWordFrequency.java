import java.util.HashMap;
import java.util.Map;

public class Problem5_StopWordFilteredWordFrequency {
    
    void printFilteredWordFrequency(String feedback) {
        // Convert to lowercase
        String lower = feedback.toLowerCase();
        
        // Remove punctuation
        lower = lower.replace(".", "").replace(",", "").replace("!", "").replace("?", "");
        
        // Split by whitespace
        String[] words = lower.split("\\s+");
        
        // Define stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        
        // Count word frequencies using HashMap
        HashMap<String, Integer> frequency = new HashMap<>();
        
        for (String word : words) {
            if (word.length() == 0) continue;
            
            // Check if word is a stop word
            boolean isStopWord = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }
            
            // Add to frequency map if not stop word
            if (!isStopWord) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency descending
        frequency.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    
    public static void main(String[] args) {
        Problem5_StopWordFilteredWordFrequency analyzer = new Problem5_StopWordFilteredWordFrequency();
        
        System.out.println("Test 1: Filter stop words and count frequency");
        analyzer.printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
