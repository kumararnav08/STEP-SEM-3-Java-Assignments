public class Problem1_FantasyTeamScoreMultiplier {
    
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: Apply multipliers to scores");
        double[] scores = {40, 55, 30, 62};
        System.out.print("Before: ");
        for (double score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        
        applyMultipliers(scores, 1, 3);
        System.out.print("After: ");
        for (double score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\nExpected: [40.0, 110.0, 30.0, 93.0]");
    }
}
