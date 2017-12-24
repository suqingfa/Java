import org.apache.commons.codec.binary.Base64;

import java.security.*;

public class KeyDemo
{
    public static void main(String[] args) throws Exception
    {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));
    }
}
