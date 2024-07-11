import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseConverter {
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("hello", "world", "java", "stream");

        // Convert each string in the list to uppercase
        List<String> upperCaseWords = words.stream()  // Convert list to stream
                .map(String::toUpperCase)  // Apply toUpperCase method on each element
                .collect(Collectors.toList());  // Collect results into a new list

        // Print the result
        System.out.println(upperCaseWords);
    }
}
