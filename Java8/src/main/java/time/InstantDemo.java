package time;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo
{
    public static void main(String[] args)
    {
        System.out.println(Instant.MIN);
        System.out.println(Instant.EPOCH);
        System.out.println(Instant.now());
        System.out.println(Instant.MAX);

        System.out.println(Instant.ofEpochSecond(987654321L));

        Instant instant = Instant.now();
        Duration duration = Duration.ofSeconds(12345678);
        System.out.println(instant.plus(duration));
    }
}
