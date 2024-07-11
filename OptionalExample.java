import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> optionalWithValue = getOptionalValue("Hello");
        optionalWithValue.ifPresent(System.out::println); // This will print "Hello"

        // Example where optional is empty
        Optional<String> optionalEmpty = getOptionalValue(null);
        String defaultValue = optionalEmpty.orElse("Default Value");
        System.out.println(defaultValue); // This will print "Default Value"
    }

    public static Optional<String> getOptionalValue(String data) {
        return Optional.ofNullable(data);
    }
}

//This example shows the safety of using Optional to avoid NullPointerException and makes it explicit when a method may not return a value, improving code readability and maintainability.