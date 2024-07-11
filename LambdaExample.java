import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Using a lambda expression to filter and print even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Using a lambda to map each number to its square and calculate sum of squares
        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of squares: " + sumOfSquares);
    }
}
