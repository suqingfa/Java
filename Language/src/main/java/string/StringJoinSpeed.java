package string;

public class StringJoinSpeed
{
    public static void main(String[] args)
    {
        final int count = 100000000;
        final int length = 100;
        long start;

        StringBuilder stringBuilder;
        StringBuffer stringBuffer;
        String string;

        // 短 string 合并
        System.out.println("short");

        stringBuilder = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
        {
            if (i % length == 0)
            {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append("a");
        }
        System.out.println("time : " + (System.currentTimeMillis() - start));

        stringBuffer = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
        {
            if (i % length == 0)
            {
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append("a");
        }
        System.out.println("time : " + (System.currentTimeMillis() - start));

        string = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
        {
            if (i % length == 0)
            {
                string = "";
            }
            string += "a";
        }
        System.out.println("time : " + (System.currentTimeMillis() - start));

        // 长 string 测试
        System.out.println("long");

        stringBuilder = new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
        {
            stringBuilder.append("a");
        }
        System.out.println("time : " + (System.currentTimeMillis() - start));

        stringBuffer = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
        {
            stringBuffer.append("a");
        }
        System.out.println("time : " + (System.currentTimeMillis() - start));

        string = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < count / 1000; i++)
        {
            string += "a";
        }
        System.out.println("time : " + (System.currentTimeMillis() - start));
    }
}
