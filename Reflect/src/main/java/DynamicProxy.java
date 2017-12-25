import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

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

        // CGLIB（Code Generation Library）实现 AOP
        Enhancer enhancer = new Enhancer();
        // 设置被代理类
        enhancer.setSuperclass(Superclass.class);
        // 设置代理的拦截器
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) ->
        {
            System.out.println(" Before invoke");
            System.out.println(" Invoke method: " + method.toGenericString());
            proxy.invokeSuper(obj, args1);
            System.out.println(" After invoke");
            return null;
        });
        Superclass inst = (Superclass) enhancer.create();
        System.out.println("Enhancer:");
        inst.invoke();
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

    static class Superclass
    {
        void invoke()
        {
            System.out.println(" invoke");
        }
    }
}
