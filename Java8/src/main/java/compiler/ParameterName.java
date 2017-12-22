package compiler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterName
{
    public static void main(String[] args)
    {
        /**
         * java8可以通过Parameter.getName()方法来获取参数名
         * 但是要在编译时带上-parameters参数
         * idea setting->build,Execution,Deployment->Compiler->Java Compiler
         * 在Additional command line parameters添加-parameters参数
         */

        for (Method method : ParameterName.class.getDeclaredMethods())
        {
            System.out.println(method.toGenericString());
            for (Parameter parameter : method.getParameters())
            {
                System.out.println(" Parameter: " + parameter.getName());
            }
        }
    }
}
