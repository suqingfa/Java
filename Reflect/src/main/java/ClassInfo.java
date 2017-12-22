import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ClassInfo implements Serializable
{
    public static void main(String[] args)
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
