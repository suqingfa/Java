import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class MessageDigestDemo
{
    public static void main(String[] args) throws Exception
    {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digest = messageDigest.digest("Hello".getBytes());
        System.out.println(Hex.encodeHexString(digest));
    }
}
