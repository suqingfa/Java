package language;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 说明某个接口是函数式接口
 * 只有有一个接口
 * 默认方法和静态方法不会破坏函数式接口的定义
 */
@FunctionalInterface
public interface Functional
{
    static void main(String[] args)
    {
        System.out.println("Hello");

        // 函数接口
        // Function<T, R>——将T作为输入，返回R作为输出
        // Predicate<T>——将T作为输入，返回一个布尔值作为输出
        // Consumer<T>——将T作为输入，不返回任何内容
        // Supplier<T>——没有输入，返回T
        // BinaryOperator<T>——将两个T作为输入，返回一个T作为输出

        // 方法引用

        // 构造器引用，语法是Class::new Class<T>::new 构造器没有参数
        // 对应的Lambda：() -> new Demo()
        Supplier<Demo> supplier = Demo::new;
        Demo inst = supplier.get();

        // 静态方法引用，语法是Class::static_method
        // 对应的Lambda：(i) -> Demo.sMethod(i)
        Consumer<Integer> consumer = Demo::sMethod;
        consumer.accept(10);

        // 成员方法的引用，语法是Class::method
        // 对应的Lambda：(s, i) -> s.iMethod(i)

        // 实例对象的成员方法的引用，语法是instance::method
        // 对应的Lambda：(s) -> inst.iMethod(s)
        consumer = inst::iMethod;
        consumer.accept(10);
    }

    void Method();

    default void defaultMethod()
    {
    }

    class Demo
    {
        static void sMethod(int i)
        {
            System.out.println("sMethod " + i);
        }

        void iMethod(int i)
        {
            System.out.println("iMethod " + i);
        }
    }
}
