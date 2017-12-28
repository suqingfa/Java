package reflect;

import java.lang.reflect.Field;

public class Change
{
    public static void main(String[] args) throws Exception
    {
        String string = "abc";
        change(string, new char[]{'1', '2', '3'});
        System.out.println(string);
        string = "abc";
        System.out.println(string);
    }

    /**
     * 通过反射强制改变 private final 字段
     * 不能用于改变原生类型(byte, char, int等)
     * 改变了常量池中的数据后，所有引用常量池中的值都会改变
     */
    private static void change(String s, Object to) throws Exception
    {
        Class<String> clazz = String.class;
        Field field = clazz.getDeclaredField("value");

        // 取消权限控制检查
        field.setAccessible(true);

        // 设置访问权限为 public
        // Field modifiersField = Field.class.getDeclaredField("modifiers");
        // modifiersField.setAccessible(true);
        // modifiersField.setInt(field, Modifier.PUBLIC);

        // 设置新值
        field.set(s, to);
    }
}
