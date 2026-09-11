public class Problem2_DuplicatePlayerPickChecker {
    
    static String findDuplicatePick(String[] playerNames) {
        // Nested loops to find duplicate
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        
        return "No Duplicates Found";
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: Array with duplicate");
        String[] players1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(players1));
        System.out.println("Expected: Duplicate Found: Kohli");
        
        System.out.println("\nTest 2: Array with no duplicates");
        String[] players2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(players2));
        System.out.println("Expected: No Duplicates Found");
    }
}
