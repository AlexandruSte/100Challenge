import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utility {

    private static int current = 1;
    private static int previous = 0;

    private static int next() {
        int temp = current + previous;
        previous = current;
        current = temp;
        return current;
    }
    public static IntStream generateFibonacciSequence() {
        // To be implemented: Proper implementation.
        return IntStream.iterate(1, i -> next());
//        return IntStream.generate(new IntSupplier() {
//            int a = 0;
//            int b = 1;
//            @Override
//            public int getAsInt() {
//                int x = a + b;
//                a = b;
//                b = x;
//                return a;
//            }
//        });
    }


    public static void main(String[] args) {
        Utility utility = new Utility();
        System.out.println(Arrays.toString(Utility.generateFibonacciSequence().limit(20).toArray()));

    }

}
