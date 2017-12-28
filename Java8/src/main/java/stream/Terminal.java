package stream;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Terminal
{
    public static void main(String[] args)
    {
        Supplier<Stream<Integer>> supplier = () -> Stream.iterate(0, n -> n + 1)
                .limit(20);

        // 简单操作
        supplier.get()
                .findFirst()
                .ifPresent(System.out::println);

        // 收集
        supplier.get()
                .forEach(System.out::println);

        Integer[] ints = supplier.get()
                .toArray(Integer[]::new);

        supplier.get()
                .collect(Collectors.toList());

        String s = supplier.get()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        Map<Integer, Integer> map = supplier.get()
                .collect(Collectors.toMap(x -> x, x -> x * x));

        // reduce
        supplier.get()
                .reduce(Integer::sum);

        supplier.get()
                .map(String::valueOf)
                .reduce(String::join);
    }
}
