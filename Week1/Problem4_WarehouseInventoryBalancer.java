public class Problem4_WarehouseInventoryBalancer {
    
    void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Calculate totals
        int totalA = 0;
        int totalB = 0;
        
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }
        
        // Determine balance status
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        
        // Find highest quantity
        int highestQuantity = sectionA[0];
        int highestPos = 0;
        String highestSection = "Section A";
        
        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestPos = i;
                highestSection = "Section A";
            }
        }
        
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestPos = i;
                highestSection = "Section B";
            }
        }
        
        // Use 1-based position numbering
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + 
                         " | Status: " + status + " | Highest Quantity: " + highestQuantity + 
                         " (" + highestSection + ", Item " + (highestPos + 1) + ")");
    }
    
    public static void main(String[] args) {
        Problem4_WarehouseInventoryBalancer balancer = new Problem4_WarehouseInventoryBalancer();
        
        System.out.println("Test 1: Balanced inventory");
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        balancer.analyzeInventory(sectionA, sectionB);
    }
}