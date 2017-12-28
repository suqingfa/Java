package reflect;

import java.lang.reflect.Constructor;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // 反射效率测试

        Constructor<Integer> constructor = Integer.class.getDeclaredConstructor(Integer.TYPE);
        // 取消了Java的权限控制检查。禁用后，在java8中提高约10%。
        constructor.setAccessible(true);

        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            constructor.newInstance(i);
        }
        System.out.println("Time : " + (System.currentTimeMillis() - start));
    }
}
