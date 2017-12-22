package language;

/**
 * 说明某个接口是函数式接口
 * 只有有一个接口
 * 默认方法和静态方法不会破坏函数式接口的定义
 */
@FunctionalInterface
public interface Functional
{
    void mothd();

    default void defaultMethod()
    {
    }

    static void main(String[] args)
    {
        System.out.println("Hello");
    }
}
