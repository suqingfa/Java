import sun.security.util.SecurityConstants;

import java.io.FilePermission;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class JavaSecurity
{
    public static void main(String[] args)
    {
        // 安全管理器
        SecurityManager securityManager = new SecurityManager(); // System.getSecurityManager();

        String file = "C:\\Windows";
        try
        {
            securityManager.checkWrite(file);
        }
        catch (SecurityException ignored)
        {
            System.out.println("通过 SecurityManager 检查到没有权限写 " + file);
        }

        // 访问控制器

        // AccessController 的一个重要功能 - 检查
        try
        {
            AccessController.checkPermission(new FilePermission(file, SecurityConstants.FILE_WRITE_ACTION));
        }
        catch (SecurityException ignored)
        {
            System.out.println("通过 AccessController 检查到没有权限写 " + file);
        }

        // AccessController 的另一个重要功能 - 授权
        AccessController.doPrivileged((PrivilegedAction<Integer>) () -> 0);
    }
}
