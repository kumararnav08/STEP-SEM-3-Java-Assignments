public class Problem4_MatchDayGridAnalyzer {
    
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }
    
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String classification = average >= threshold ? "Power Surge" : "Normal";
            
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(classification);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: Classify matches");
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(runsPerOver, threshold));
        System.out.println("Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal");
    }
}
