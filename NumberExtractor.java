import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {
    public static void main(String[] args) {
        // Example input string
        String input = "The total cost is 1200 and the tax rate is 15.75. Another value is -35 and discount is 3.50.";
        // Regular expression patterns for integers and decimal values
        String integerPattern = "-?\\b\\d+\\b";
        String decimalPattern = "-?\\b\\d+\\.\\d+\\b";
        // Compile patterns
        Pattern intPattern = Pattern.compile(integerPattern);
        Pattern decPattern = Pattern.compile(decimalPattern);
        // Match and find integers
        System.out.println("Integers found:");
        Matcher intMatcher = intPattern.matcher(input);
        while (intMatcher.find()) {
            System.out.println(intMatcher.group());
        }
        // Match and find decimal values
        System.out.println("\nDecimal values found:");
        Matcher decMatcher = decPattern.matcher(input);
        while (decMatcher.find()) {
            System.out.println(decMatcher.group());
        }
    }
}