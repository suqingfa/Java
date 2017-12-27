package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GetStream
{
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5};

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream();
        list.parallelStream();

        Arrays.stream(array);

        Stream.of(1, 2, 3, 4, 5);
        Stream.generate(() -> 1);
        Stream.iterate(0, t -> t + 1);

        // Files.lines()
    }
}
