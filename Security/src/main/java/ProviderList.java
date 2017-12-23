import java.security.*;
import java.util.Map;

public class ProviderList
{
    public static void main(String[] args)
    {
        // 输出安全提供者信息
        for (Provider provider : Security.getProviders())
        {
            System.out.println(provider);
            for (Map.Entry<Object, Object> entry : provider.entrySet())
            {
                System.out.println("\t" + entry.getKey());
            }
        }
    }
}
