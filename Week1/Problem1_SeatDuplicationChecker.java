public class Problem1_SeatDuplicationChecker {
    
    void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        
        // Nested loop to compare every seat with every other seat
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    // Check if we already printed this duplicate
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        foundDuplicate = true;
                    }
                    break;
                }
            }
        }
        
        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    
    public static void main(String[] args) {
        Problem1_SeatDuplicationChecker checker = new Problem1_SeatDuplicationChecker();
        
        System.out.println("Test 1: Array with duplicate 102");
        int[] test1 = {101, 102, 103, 102, 105};
        checker.checkDuplicateSeats(test1);
        
        System.out.println("\nTest 2: Array with no duplicates");
        int[] test2 = {101, 102, 103, 104, 105};
        checker.checkDuplicateSeats(test2);
    }
}