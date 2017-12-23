import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class ProviderList
{
    public static void main(String[] args)
    {
        // 动态添加Provider
        Security.addProvider(new BouncyCastleProvider());

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
