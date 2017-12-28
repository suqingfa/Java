package stream;

import java.util.Set;
import java.util.function.IntSupplier;
import java.util.stream.*;

public class StreamDemo
{
    public static void main(String[] args)
    {
        // +--------------------+       +------+   +------+   +---+   +-------+
        // | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
        // +--------------------+       +------+   +------+   +---+   +-------+

        // 创建流
        // 一 Collection.stream 从Collection对象上调用stream()方法可以返回一个常规的对象流
        // 二 直接使用Stream.of()方法/Arrays.stream()方法
        // 三 IntStream,LongStream,DoubleStream 等特殊流

        // 通过常规对象流（regular object stream）的mapToInt(), mapToLong()，mapToDouble()，
        // 基本类型对象流（primitive streams）中的mapToObj()
        // 等方法完成常规对象流和基本类型流之间的相互转换

        IntStream intStream = IntStream.generate(new IntSupplier()
        {
            int cur = 1;
            int next = 1;

            @Override
            public int getAsInt()
            {
                int t = cur;
                cur = next;
                next += t;
                return t;
            }
        });

        System.out.println("IntStream");
        intStream.limit(10)
                .forEach(System.out::println);

        // collect 把stream中的元素转换成另外一种形式
        Set<Integer> set = Stream.of(1, 1, 2, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println("Collectors");
        set.forEach(System.out::println);

        // reduce 将stream中所有元素组合起来得到一个元素
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (x, y) -> x + y);
        System.out.println("reduce " + sum);
    }
}
