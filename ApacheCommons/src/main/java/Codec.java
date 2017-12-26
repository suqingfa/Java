import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class Codec
{
    public static void main(String[] args)
    {
        byte[] bytes = {1, 2, 3, 4, 5};

        System.out.println(Base64.encodeBase64String(bytes));
        System.out.println(Hex.encodeHexString(bytes));
        System.out.println(DigestUtils.sha1Hex(bytes));
    }
}
