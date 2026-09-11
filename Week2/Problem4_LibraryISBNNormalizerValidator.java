public class Problem4_LibraryISBNNormalizerValidator {
    
    String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String first3Upper = trimmed.substring(0, 3).toUpperCase();
        String remaining = trimmed.substring(3);
        return first3Upper + remaining;
    }
    
    String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: ISBN must be exactly 13 characters";
        }
        
        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog must be digits";
            }
        }
        
        // Extract components
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] YEAR: ").append(year);
        formatted.append(" | CATALOG: ").append(catalog);
        
        return formatted.toString();
    }
    
    public static void main(String[] args) {
        Problem4_LibraryISBNNormalizerValidator validator = new Problem4_LibraryISBNNormalizerValidator();
        
        System.out.println("Test 1: Valid ISBN");
        String normalized1 = validator.normalizeCode(" pen2026004251 ");
        System.out.println("Normalized: " + normalized1);
        String formatted1 = validator.validateAndFormat(normalized1);
        System.out.println(formatted1);
        
        System.out.println("\nTest 2: Invalid ISBN - starts with digit");
        String formatted2 = validator.validateAndFormat("12N2026004251");
        System.out.println(formatted2);
    }
}
