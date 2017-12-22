import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.*;

@Resource(name = "ClassInfo")
public class ClassInfo implements Serializable
{
    public static void main(String[] args) throws Exception
    {
        Class clazz = ClassInfo.class;

        InputStream inputStream = clazz.getResourceAsStream("test.txt");
        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        System.out.println(new String(buffer));

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

        // 获取注解
        Resource resource = (Resource) clazz.getAnnotation(Resource.class);
        System.out.println("Annotation name:" + resource.name());
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
