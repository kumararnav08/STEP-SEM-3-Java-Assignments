public class Problem3_ProductInventoryCSVParser {
    
    void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        }
    }
    
    public static void main(String[] args) {
        Problem3_ProductInventoryCSVParser parser = new Problem3_ProductInventoryCSVParser();
        
        System.out.println("Test 1: Valid CSV record");
        parser.parseInventoryRecord("Wireless Mouse,WM-2201,150");
        
        System.out.println("\nTest 2: Invalid record - missing field");
        parser.parseInventoryRecord("Wireless Mouse,150");
    }
}
