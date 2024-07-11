import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Using a method reference
        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperWords);  // Output: [APPLE, BANANA, CHERRY]
    }
}
