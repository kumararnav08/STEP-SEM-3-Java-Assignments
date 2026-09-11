import java.util.Arrays;

public class Problem5_FantasyLeagueAutoDraftRankingEngine {
    
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;
        
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        
        // Overloaded method: experience-only rule
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }
        
        // Overloaded method: combined rule
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return (matchesPlayed >= 10) || (matchesPlayed >= 5 && !injured);
        }
        
        // Check if this player is draftable
        boolean isDraftable() {
            return isDraftable(this.matchesPlayed, this.injured);
        }
        
        @Override
        public int compareTo(Player other) {
            // Sort by batting average in descending order
            return Double.compare(other.battingAverage, this.battingAverage);
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    static String draftAndRank(Player[] players) {
        // Filter draftable players
        java.util.List<Player> draftableList = new java.util.ArrayList<>();
        
        for (Player player : players) {
            if (player.isDraftable()) {
                draftableList.add(player);
            }
        }
        
        // Convert to array
        Player[] draftableArray = draftableList.toArray(new Player[0]);
        
        // Sort using Arrays.sort
        Arrays.sort(draftableArray);
        
        // Build ranking string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append((i + 1)).append(". ").append(draftableArray[i].name);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: Draft and rank players");
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        
        String ranking = draftAndRank(players);
        System.out.println(ranking);
        System.out.println("Expected: 1. Rahul | 2. Virat | 3. Dev");
    }
}
