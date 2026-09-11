public class Problem1_ATMPinLengthValidator {
    
    void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
    
    public static void main(String[] args) {
        Problem1_ATMPinLengthValidator validator = new Problem1_ATMPinLengthValidator();
        
        System.out.println("Test 1: PIN too short");
        validator.checkPinLength("482");
        
        System.out.println("\nTest 2: PIN correct length");
        validator.checkPinLength("4820");
    }
}
