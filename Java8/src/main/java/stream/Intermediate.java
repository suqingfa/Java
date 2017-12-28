package stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Intermediate
{
    public static void main(String[] args)
    {
        Supplier<Stream<Integer>> supplier = () -> Stream.iterate(0, n -> n + 1)
                .limit(20);

        System.out.println("filter map ");
        supplier.get()
                .filter(x -> x % 5 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

        System.out.println("limit skip");
        supplier.get()
                .skip(3)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("peek sorted");
        supplier.get()
                .sorted((x, y) -> y - x)
                .peek(System.out::println)
                .forEach(System.out::println);
    }
}
