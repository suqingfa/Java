package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        Pattern pattern = Pattern.compile("java ([a-f]*) (\\d*)");
        Matcher matcher = pattern.matcher("java abc 123463");

        // 匹配整个字符串
        System.out.println(matcher.matches());
        for (int i = 0; i <= matcher.groupCount(); i++)
        {
            System.out.println(matcher.group(i));
        }

        // 匹配部分
        matcher = pattern.matcher("abc java abc 1234 java aaa 111");
        while (matcher.find())
        {
            int start = matcher.start();
            int end = matcher.end();
            String match = matcher.group();
            System.out.println(start + " - " + end + " " + match);
        }
    }
}
