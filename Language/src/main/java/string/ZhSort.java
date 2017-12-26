package string;

import java.text.Collator;
import java.util.*;

public class ZhSort
{
    public static void main(String[] args)
    {
        // 中文排序
        List<String> words = Arrays.asList("一", "二", "三", "四");
        words.sort(Collator.getInstance(Locale.CHINA));
        words.stream().reduce((a, b) -> a + " " + b).ifPresent(System.out::println);
    }
}
