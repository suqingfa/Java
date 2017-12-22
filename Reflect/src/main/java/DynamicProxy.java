import java.lang.reflect.*;

public class DynamicProxy implements InvocationHandler
{
    public static void main(String[] args)
    {
        // 动态代理只能代理接口，不能代理类和抽象类
        DoSomething doSomething = (DoSomething) Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(),    // 类加载器
                new Class[]{DoSomething.class},         // 代理的接口
                new DynamicProxy());                    // 代理类

        doSomething.doSomething();
        doSomething.toString();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Class clazz = method.getDeclaringClass();
        System.out.println("proxy: " + clazz.toGenericString());
        System.out.println("invoke: " + method.toGenericString());
        return null;
    }

    interface DoSomething
    {
        void doSomething();
    }
}
