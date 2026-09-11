public class Problem3_TrafficSignalStreakAnalyzer {
    
    void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            return;
        }
        
        char longestChar = signalLog.charAt(0);
        int longestLength = 1;
        
        char currentChar = signalLog.charAt(0);
        int currentLength = 1;
        
        // Scan left to right tracking consecutive identical characters
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLength++;
            } else {
                // Check if current streak is longer
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestChar = currentChar;
                }
                // Start new streak
                currentChar = signalLog.charAt(i);
                currentLength = 1;
            }
        }
        
        // Check last streak
        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestChar = currentChar;
        }
        
        System.out.println("Longest Streak: '" + longestChar + "' repeated " + longestLength + " times");
    }
    
    public static void main(String[] args) {
        Problem3_TrafficSignalStreakAnalyzer analyzer = new Problem3_TrafficSignalStreakAnalyzer();
        
        System.out.println("Test 1: RRGGGYRR");
        analyzer.findLongestStreak("RRGGGYRR");
        
        System.out.println("\nTest 2: RRRRYYGG");
        analyzer.findLongestStreak("RRRRYYGG");
    }
}