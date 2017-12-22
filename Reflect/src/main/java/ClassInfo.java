import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.*;

public class ClassInfo implements Serializable
{
    public static void main(String[] args) throws Exception
    {
        Class clazz = ClassInfo.class;

        // 获取类的内部类
        clazz.getDeclaredClasses();
        // 获取类的外部类
        clazz.getDeclaringClass();

        // 获取类实现的接口
        for (Class interfaceClass : clazz.getInterfaces())
        {
            System.out.println(interfaceClass.toGenericString());
        }

        // 类构造函数
        System.out.println("getConstructors:");
        for (Constructor constructor : clazz.getConstructors())
        {
            System.out.println(" " + constructor.toGenericString());
        }

        // 类申明的字段
        System.out.println("getDeclaredFields:");
        for (Field field : clazz.getDeclaredFields())
        {
            System.out.println(" " + field.toGenericString());
        }

        // 类方法
        System.out.println("getDeclaredMethods:");
        for (Method method : clazz.getDeclaredMethods())
        {
            System.out.println(" " + method.toGenericString());
        }

        // 动态创建对象 设置字段/调用方法
        ClassInfo inst = (ClassInfo) clazz.newInstance();
        Field puField = clazz.getField("pu");
        puField.setInt(inst, 1234);
        int pu = puField.getInt(inst);
        System.out.println("Field.getInt: " + pu);
    }

    @Getter
    @Setter
    private int pv;

    protected int po;

    public int pu;

    public static int ps;

    public static void psMethod()
    {
    }

    public void puMethod()
    {
    }

    protected void poMethod()
    {
    }

    private void pvMethod()
    {
    }
}
