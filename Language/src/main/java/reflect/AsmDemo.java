package reflect;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Field;

public class AsmDemo
{
    public static void main(String[] args) throws Exception
    {
        // 生成新类
        /*
         *  public interface Comparable
         *  {
         *       int LESS = -1;
         *       int EQUAL = 0;
         *       int GREATER = 1;
         *       int compareTo(Object o);
         &   }
         * */
        ClassWriter classWriter = new ClassWriter(0);

        // 通过visit方法确定类的头部信息
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE, "Comparable", null, "java/lang/Object", null);

        // 定义类的属性
        classWriter.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, -1)
                .visitEnd();
        classWriter.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I", null, 0)
                .visitEnd();
        classWriter.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I", null, 1)
                .visitEnd();

        // 定义类的方法
        classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
                .visitEnd();

        // 完成类定义
        classWriter.visitEnd();

        // 将 classWriter 转换成字节数组
        byte[] data = classWriter.toByteArray();

        Class classComparable = new ClassLoader()
        {
            Class<?> defineClass()
            {
                return defineClass("Comparable", data, 0, data.length);
            }
        }.defineClass();

        System.out.println(classComparable.getName());
        for (Field field : classComparable.getDeclaredFields())
        {
            System.out.println(field.getName());
        }
    }
}
